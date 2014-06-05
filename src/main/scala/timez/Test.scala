
import java.time._
import scalaz._, Scalaz._
import timez._, Timez._

object Test extends App {

  {
    now[LocalDateTime].println
  }
  {
    implicit val clock = Clock.systemUTC()
    now[LocalDateTime].println
  }

}

