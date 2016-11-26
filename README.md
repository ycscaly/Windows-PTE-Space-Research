# Windows-PTE-Space-Research

This is a small research I've done on the PTE space in Windows.
As the PTE_BASE are fixed (Until it is randomized in some Windows 10 update), this is actually a static research (which doesn't interact 
with a Windows OS in any manner.)

Read more about the pte space in my notebook:
https://1drv.ms/u/s!AqiuStAQmFgxhWnzIysmySzjSqMN
	
Windows 32-bit PTE space information
The page tables are based at 0xc0000000
The page directory table is at 0xc0300000
The fixed point is at 0xc0300c00
The self-reference selector is 0x300}
Done printing 32-bit PTE space information

	
Windows 64-bit PTE space information
The page tables are based at 0xfffff68000000000
The page directory tables start at 0xfffff6bda0000000
The page directory pointer tables start at 0xfffff6bdaf680000
The page map level 4 table is at 0xfffff6bdaf6bda00
The fixed point is at 0xfffff6bdaf6bdaf4
The self-reference selector is 0x1ed
Done printing 64-bit PTE space information
