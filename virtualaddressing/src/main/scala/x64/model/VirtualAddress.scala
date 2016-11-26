package x64.model

import bitwise.BitwiseOperations
import misc.Misc

/**
  * Created by JC on 04/12/2015.
  */
case class VirtualAddress(
                           reservedCanonicalField: Int, //Is either 0xFFFF or 0x0000 depending on pml4 selector's MSB
                           pageMapLevel4Selector: Int,
                           pageDirectoryPointerSelector: Int,
                           pageDirectorySelector: Int, //Called pageTableSelector in windows internals
                           pageTableSelector: Int,
                           offsetWithinPage: Int
                            ) {
  override def toString =
    "Page Map Level 4 Selector: " + Misc.toHexString(pageMapLevel4Selector) + "\n" +
    "Page Directory Pointer Selector: " + Misc.toHexString(pageDirectoryPointerSelector) + "\n" +
    "Page Directory Selector: " + Misc.toHexString(pageDirectorySelector) + "\n" +
    "Page Table Selector: " + Misc.toHexString(pageTableSelector) + "\n" +
    "Byte Within Page: " + Misc.toHexString(offsetWithinPage)



  def toRawAddress: Long = {
    ((reservedCanonicalField.toLong << 48) +
      (pageMapLevel4Selector.toLong) << 39 +
      (pageDirectoryPointerSelector.toLong) << 30 +
      (pageDirectorySelector.toLong) << 21 +
      (pageTableSelector.toLong) << 12 +
      offsetWithinPage)
  }

  def toRawAddressWithoutReservedField: Long = {
    ((pageMapLevel4Selector.toLong << 39) +
      (pageDirectoryPointerSelector.toLong << 30) +
      (pageDirectorySelector.toLong << 21) +
      (pageTableSelector.toLong << 12) +
      (offsetWithinPage.toLong))
  }
}

object VirtualAddress{
  def apply(virtualAddress: Long): VirtualAddress =
    new VirtualAddress(
      BitwiseOperations.getBits(virtualAddress,48,63).toInt,
      BitwiseOperations.getBits(virtualAddress,39,47).toInt,
      BitwiseOperations.getBits(virtualAddress,30,38).toInt,
      BitwiseOperations.getBits(virtualAddress,21,29).toInt,
      BitwiseOperations.getBits(virtualAddress,12,20).toInt,
      BitwiseOperations.getBits(virtualAddress,0,11).toInt
    )
}