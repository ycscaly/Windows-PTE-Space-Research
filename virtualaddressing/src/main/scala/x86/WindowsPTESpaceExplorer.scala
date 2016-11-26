package x86

import model.VirtualAddress

object WindowsPTESpaceExplorer{
	val PTE_BASE: Int = 0xc0000000 

	def addressToPTE(address: Int): Int =
		return (Integer.divideUnsigned(address,4096) << 2) + PTE_BASE

	def printPTESpaceInformation() =
	{
		val pageDirectoryTableAddress = addressToPTE(PTE_BASE)
		val fixedPoint = addressToPTE(pageDirectoryTableAddress)

		assert(fixedPoint == addressToPTE(fixedPoint))

		println(s"\n\nWindows 32-bit PTE space information")
		println(s"The page tables are based at 0x${PTE_BASE.toHexString}")
		println(s"The page directory table is at 0x${pageDirectoryTableAddress.toHexString}")
		println(s"The fixed point is at 0x${fixedPoint.toHexString}")
		println(s"The self-reference selector is 0x${VirtualAddress(fixedPoint).pageDirectorySelector.toHexString}}")
		println("Done printing 32-bit PTE space information\n\n")
	}

}