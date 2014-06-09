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
package timez.syntax.time

import java.time._
import java.time.temporal.TemporalField

trait LocalDateTimeOps extends Ops[LocalDateTime] {

  def &(offset: ZoneOffset) = self.atOffset(offset)
  def &(zone: ZoneId) = self.atZone(zone)

  def apply(field: TemporalField) = self.get(field)

  def dayOfMonth = self.getDayOfMonth
  def dayOfWeek = self.getDayOfWeek
  def dayOfYear = self.getDayOfYear
  def hour = self.getHour
  def minute = self.getMinute
  def month = self.getMonth
  def nano = self.getNano
  def second = self.getSecond
  def year = self.getYear
}

trait LocalDateTimeSyntax {
  implicit def ToLocalDateOps(ld: LocalDateTime) = new LocalDateTimeOps {
    override def self = ld
  }
}