package x64

import x64.model.VirtualAddress

/**
  * Created by JC on 26/11/2016.
  */
object WindowsPTESpaceExplorer {
  val PTE_BASE: Long = 0xFFFFF68000000000L

  def stripReservedField(address: Long): Long =
    return VirtualAddress(address).toRawAddressWithoutReservedField

  //Note: the math calculations should be done on the address after its striped from the reserved field.
  def addressToPTE(address: Long): Long =
    return ((stripReservedField(address) >> 12) << 2) + PTE_BASE

  def printPTESpaceInformation() =
  {
    val pageDirectoryTablesStartAddress = addressToPTE(PTE_BASE)
    val pageDirectoryPointerTablesStartAddress = addressToPTE(pageDirectoryTablesStartAddress)
    val pageMapLevel4TableAddress = addressToPTE(pageDirectoryPointerTablesStartAddress)
    val fixedPoint = addressToPTE(pageMapLevel4TableAddress)

    assert(fixedPoint == addressToPTE(fixedPoint))

    println(s"\n\nWindows 64-bit PTE space information")
    println(s"The page tables are based at 0x${PTE_BASE.toHexString}")
    println(s"The page directory tables start at 0x${pageDirectoryTablesStartAddress.toHexString}")
    println(s"The page directory pointer tables start at 0x${pageDirectoryPointerTablesStartAddress.toHexString}")
    println(s"The page map level 4 table is at 0x${pageMapLevel4TableAddress.toHexString}")
    println(s"The fixed point is at 0x${fixedPoint.toHexString}")
    println(s"The self-reference selector is 0x${VirtualAddress(pageDirectoryTablesStartAddress).pageMapLevel4Selector.toHexString}")
    println("Done printing 64-bit PTE space information\n\n")
  }
}
