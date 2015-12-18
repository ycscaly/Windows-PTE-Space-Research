package main

import x64.AddressTranslation


/**
  * Created by JC on 06/12/2015.
  */
object Main {

  def main(args: Array[String])  {

    val address = "0x000000e760cc0312"
    val pageMapLevel4Address = "0x4296e000"
    val pml4eAddress = "0x4296e008"
    val pml4e = "0x0150000017863867"
    val pdpteAddress = "0x17863ce8"
    val pdpte = "0x019000001b3e4867"
    val pdeAddress = "0x1b3e4830"
    val pde = "0x0170000020565867"
    val pteAddress = "0x20565600"
    val pte = "0x9c60000075c26867"
    val physicalAddress = "0x75c26312"

    AddressTranslation.virtualToPhysical()


  }

}
