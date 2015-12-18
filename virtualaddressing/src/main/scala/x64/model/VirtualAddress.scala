package x64.model

import bitwise.BitwiseOperations
import misc.Misc

/**
  * Created by JC on 04/12/2015.
  */
case class VirtualAddress(
                               pageMapLevel4Selector: Int,
                               pageDirectoryPointerSelector: Int,
                               pageDirectorySelector: Int, //Called pageTableSelector in windows internals
                               pageTableSelector: Int,
                               byteWithinPage: Int
                            ) {
  override def toString =
    "Page Map Level 4 Selector: " + Misc.toHexString(pageMapLevel4Selector) + "\n" +
    "Page Directory Pointer Selector: " + Misc.toHexString(pageDirectoryPointerSelector) + "\n" +
    "Page Directory Selector: " + Misc.toHexString(pageDirectorySelector) + "\n" +
    "Page Table Selector: " + Misc.toHexString(pageTableSelector) + "\n" +
    "Byte Within Page: " + Misc.toHexString(byteWithinPage)

}

object VirtualAddress{
  def apply(virtualAddress: Long): VirtualAddress =
    new VirtualAddress(
      BitwiseOperations.getBits(virtualAddress,39,47).toInt,
      BitwiseOperations.getBits(virtualAddress,30,38).toInt,
      BitwiseOperations.getBits(virtualAddress,21,29).toInt,
      BitwiseOperations.getBits(virtualAddress,12,20).toInt,
      BitwiseOperations.getBits(virtualAddress,0,11).toInt
    )
}