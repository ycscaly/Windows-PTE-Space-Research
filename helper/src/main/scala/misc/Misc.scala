package misc

/**
  * Created by JC on 05/12/2015.
  */

object Misc {

  val hexedecimalBase = "0123456789abcdef"
  //This method also prints the user a desciprion message
  def input64BitAddress(): Long = {
    println("Please input a 64 bit address in hex form; e.g., output from dp command in WinDBG")
    input64BitHex()
  }

  def input64BitHex(): Long = {

    val rawInput = readLine()
    val hexString = rawInput.replace("0x","").filter(hexedecimalBase.contains(_)).toLowerCase

    assert(hexString.length <= 16, "Inputted more than 64bits hex")

    Misc.hexToLong(hexString)

  }

  def input32BitHex(): Int = {
    val rawInput = readLine()
    val hexString = rawInput.replace("0x","").filter(hexedecimalBase.contains(_)).toLowerCase

    assert(hexString.length <= 8,"Inputted more than 32bits hex")

    Misc.hexToInt(hexString)
  }

  def toHexString(value: Int) =
    Integer.toHexString(value)

  def toHexString(value: Long) =
    Integer.toHexString((value >> 32 ).toInt) + Integer.toHexString(value.toInt).replace("0x","")

  //TODO: check why an errorsome output is returned on input "e760cc0312"
  def hexToInt(s: String): Int =
    s.toList.map(hexedecimalBase.indexOf(_)).reduceLeft(_ * hexedecimalBase.length + _)



  def hexToLong(s: String): Long =
    s.toList.map(hexedecimalBase.indexOf(_).toLong).reduceLeft(_ * hexedecimalBase.length + _)






}
