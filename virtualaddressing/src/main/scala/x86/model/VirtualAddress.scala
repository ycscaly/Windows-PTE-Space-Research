package x86.model

import bitwise.BitwiseOperations
import misc.Misc

/**
  * Created by JC on 04/12/2015.
  */
case class VirtualAddress(
                               pageDirectorySelector: Int, 
                               pageTableSelector: Int,
                               offsetWithinPage: Int 
                          ) {
  override def toString =
    "Page Directory Selector: " + Misc.toHexString(pageDirectorySelector) + "\n" +
    "Page Table Selector: " + Misc.toHexString(pageTableSelector) + "\n" +
    "Byte Within Page: " + Misc.toHexString(offsetWithinPage)
}

object VirtualAddress{
  def apply(virtualAddress: Int): VirtualAddress =
    new VirtualAddress(
      BitwiseOperations.getBits(virtualAddress,22,31).toInt,
      BitwiseOperations.getBits(virtualAddress,12,21).toInt,
      BitwiseOperations.getBits(virtualAddress,0,11).toInt
    )
}