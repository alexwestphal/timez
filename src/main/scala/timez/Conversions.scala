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
 * @author Alex Westphal 09/Jun/2014
 * @version 09/Jun/2014
 */
package timez

import java.time._
import java.time.temporal.Temporal

trait Conversions {
  import Conversions._

  implicit val LocalDateTimeToLocalDate: TemporalConversion[LocalDateTime, LocalDate] = _.toLocalDate
  implicit val LocalDateTimeToLocalTime: TemporalConversion[LocalDateTime, LocalTime] = _.toLocalTime

  implicit val OffsetDateTimeToInstant: TemporalConversion[OffsetDateTime, Instant] = _.toInstant
  implicit val OffsetDateTimeToLocalDate: TemporalConversion[OffsetDateTime, LocalDate] = _.toLocalDate
  implicit val OffsetDateTimeToLocalDateTime: TemporalConversion[OffsetDateTime, LocalDateTime] = _.toLocalDateTime
  implicit val OffsetDateTimeToLocalTime: TemporalConversion[OffsetDateTime, LocalTime] = _.toLocalTime
  implicit val OffsetDateTimeToOffsetTime: TemporalConversion[OffsetDateTime, OffsetTime] = _.toOffsetTime
  implicit val OffsetDateTimeToZonedDateTime: TemporalConversion[OffsetDateTime, ZonedDateTime] = _.toZonedDateTime

  implicit val OffsetTimeToLocalTime: TemporalConversion[OffsetTime, LocalTime] = _.toLocalTime

  implicit val ZonedDateTimeToLocalDate: TemporalConversion[ZonedDateTime, LocalDate] = _.toLocalDate
  implicit val ZonedDateTimeToLocalDateTime: TemporalConversion[ZonedDateTime, LocalDateTime] = _.toLocalDateTime
  implicit val ZonedDateTimeToLocalTime: TemporalConversion[ZonedDateTime, LocalTime] = _.toLocalTime
  implicit val ZonedDateTimeToOffsetDateTime: TemporalConversion[ZonedDateTime, OffsetDateTime] = _.toOffsetDateTime
}

object Conversions extends Conversions {
  type TemporalConversion[A <: Temporal,B <: Temporal] = A => B

  object TemporalConversion {
    @inline def apply[A <: Temporal,B <: Temporal](implicit TC: TemporalConversion[A,B]) = TC
  }
}
