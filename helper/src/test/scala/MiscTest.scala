import org.scalatest.FlatSpec

/**
  * Created by JC on 18/12/2015.
  */
import misc.Misc._
class MiscTest extends FlatSpec{

  "hexToLong" should "Successfully convert a long(er than 32 bits) hexadecimal number " in {

    assertResult(993761428242L){
      hexToLong("e760cc0312")
    }

  }
}
