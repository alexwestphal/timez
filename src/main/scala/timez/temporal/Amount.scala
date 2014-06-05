/**
 * Copyright (c) 2002-2014, OnPoint Digital, Inc. All rights reserved
 *
 * THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @author Alex Westphal 30/May/2014
 * @version 30/May/2014
 */
package timez.temporal

import java.time.temporal.{ChronoUnit, Temporal, TemporalAmount, TemporalUnit}
import java.time.{Period, Duration}
import java.util.{List => JList}

import scala.collection.JavaConversions._

trait Amount extends TemporalAmount {

  val amount: Int
  val unit: TemporalUnit

  def addTo(temporal: Temporal): Temporal = temporal.plus(amount, unit)
  def get(unit: TemporalUnit): Long = if(unit == this.unit) amount else 0
  def getUnits: JList[TemporalUnit] = unit :: Nil
  def subtractFrom(temporal: Temporal): Temporal = temporal.minus(amount, unit)


}

object Amount {

  def apply(a: Int, u: TemporalUnit) = new Amount {
    override val amount: Int = a
    override val unit: TemporalUnit = u
  }


  trait DurationAmount extends Amount {
    def asDuration: Duration = Duration.of(amount, unit)
  }
  trait PeriodAmount extends Amount {
    def asPeriod: Period
  }

  // Duration Units
  case class Hours(amount: Int) extends DurationAmount { val unit = ChronoUnit.HOURS}
  case class Millis(amount: Int) extends DurationAmount { val unit = ChronoUnit.MILLIS }
  case class Minutes(amount: Int) extends DurationAmount { val unit = ChronoUnit.MINUTES }
  case class Nanos(amount: Int) extends DurationAmount { val unit = ChronoUnit.NANOS }
  case class Seconds(amount: Int) extends DurationAmount { val unit = ChronoUnit.SECONDS }

  // Combined Duration and Period unit
  case class Days(amount: Int) extends DurationAmount with PeriodAmount {
    val unit = ChronoUnit.DAYS; def asPeriod = Period.ofDays(amount)
  }

  // Period Units
  case class Centuries(amount: Int) extends PeriodAmount {
    val unit = ChronoUnit.CENTURIES; def asPeriod = Period.ofYears(amount*100)
  }
  case class Decades(amount: Int) extends PeriodAmount {
    val unit = ChronoUnit.DECADES; def asPeriod = Period.ofYears(amount*10)
  }
  case class Millennia(amount: Int) extends PeriodAmount {
    val unit = ChronoUnit.MILLENNIA; def asPeriod = Period.ofYears(amount*1000)
  }
  case class Months(amount: Int) extends PeriodAmount {
    val unit = ChronoUnit.MONTHS; def asPeriod = Period.ofMonths(amount)
  }
  case class Weeks(amount: Int) extends PeriodAmount {
    val unit = ChronoUnit.WEEKS; def asPeriod = Period.ofWeeks(amount)
  }
  case class Years(amount: Int) extends PeriodAmount {
    val unit = ChronoUnit.YEARS; def asPeriod = Period.ofYears(amount)
  }

  // Conversions
  implicit def DurationAmountToDuration(a: DurationAmount): Duration = a.asDuration
  implicit def PeriodAmountToPeriod(a: PeriodAmount): Period = a.asPeriod
}
