package bitwise

/**
  * Created by JC on 04/12/2015.
  */

object BitwiseOperations {

  def getBits(value: Long,startBit: Int, endBit: Int): Long =
    (value >> startBit) & oneBits(endBit - startBit + 1)

  def getBit(value: Long, index: Int) =
    getBits(value,index,index) == 1

  def oneBits(length: Int): Long =
  {
    require(length >= 0, length <= 63)
    (Math.pow(2,length) - 1).toLong
  }

}
