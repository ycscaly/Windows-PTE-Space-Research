package x64

import misc.Misc
import x64.model.{PageEntry, VirtualAddress}


object AddressTranslation {

  def virtualToPhysical(
                             virtualAddressRaw: Long,
                             pageTableEntryRaw: Long
                           ): Long = {

    val virtualAddress = VirtualAddress(virtualAddressRaw)
    val physicalAddress = PageEntry.physicalAddressFromPTE(pageTableEntryRaw,virtualAddress.offsetWithinPage)
    physicalAddress

  }

    def virtualToPhysical(): Long = {

      println("Input the Virtual Address to be translated")
      val virtualAddressRaw: Long = Misc.input64BitAddress()
      val virtualAddress = VirtualAddress(virtualAddressRaw)
      println(virtualAddress)

      println("\n\nInput the page map level 4 entry")
      val pageMapLevel4EntryRaw: Long = Misc.input64BitAddress()
      val pageMapLevel4Entry = PageEntry(pageMapLevel4EntryRaw)
      println(pageMapLevel4Entry)
      println("The page directory pointer entry is at address: " +
        Misc.toHexString(PageEntry.nextLevelEntryAddress(pageMapLevel4EntryRaw,virtualAddress.pageDirectoryPointerSelector) ))

      println("\n\nInput the page directory pointer entry")
      val pageDirectoryPointerEntryRaw: Long =  Misc.input64BitAddress()
      val pageDirctoryPointerEntry = PageEntry(pageDirectoryPointerEntryRaw)
      println(pageDirctoryPointerEntry)
      println("The page directory pointer entry is at address: " +
        Misc.toHexString(PageEntry.nextLevelEntryAddress(pageDirectoryPointerEntryRaw,virtualAddress.pageDirectorySelector) ))

      println("\n\nInput the page directory entry")
      val pageDirectoryEntryRaw: Long = Misc.input64BitAddress()
      val pageDirectoryEntry = PageEntry(pageDirectoryEntryRaw)
      println(pageDirectoryEntry)
      println("The page directory table entry is at address: " +
        Misc.toHexString(PageEntry.nextLevelEntryAddress(pageDirectoryEntryRaw,virtualAddress.pageTableSelector) ))

      println("\n\nInput the page table entry")
      val pageTableEntryRaw: Long = Misc.input64BitAddress()
      val pageTableEntry = PageEntry(pageTableEntryRaw)
      println(pageTableEntry)

      val physicalAddress = virtualToPhysical(virtualAddressRaw,pageTableEntryRaw)
      println("Physical Address: " + Misc.toHexString(physicalAddress))

      physicalAddress
    }



}
