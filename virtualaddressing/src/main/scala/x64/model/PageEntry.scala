package x64.model

import misc.Misc
import bitwise.BitwiseOperations
/**
  * Created by JC on 04/12/2015.
  */
case class PageEntry(
                       executable: Boolean,
                       nextLevelBaseAddress: Long,
                       supervisor: Boolean,
                       writeable: Boolean
                       ){

  override def toString =
    (if(executable) "An executable " else "A non-executable ") +
    (if(writeable) "writeable " else "non-writeable ") +
    (if(supervisor) "kernel mode entry" else "user mode entry") +
    "with next level base address of: " + Misc.toHexString(nextLevelBaseAddress)

}



object PageEntry{
  def apply(entry: Long): PageEntry =
    new PageEntry(
      BitwiseOperations.getBit(entry,63),
      BitwiseOperations.getBits(entry,12,39),
      BitwiseOperations.getBit(entry,2),
      BitwiseOperations.getBit(entry,1)
    )

  def nextLevelEntryAddress(entry: Long,nextLevelIndex: Int) =
    (PageEntry(entry).nextLevelBaseAddress << 12) + nextLevelIndex * 8

  def physicalAddressFromPTE(pageTableEntryRaw:Long, byteWithinPage:Int) =
    (PageEntry(pageTableEntryRaw).nextLevelBaseAddress << 12) + byteWithinPage


}