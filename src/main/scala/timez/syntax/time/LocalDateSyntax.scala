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

import java.time.{Period, OffsetTime, LocalTime, LocalDate}
import java.time.temporal.TemporalField


trait LocalDateOps extends Ops[LocalDate] {

  def &(hour: Int, minute: Int) = self.atTime(hour, minute)
  def &(hour: Int, minute: Int, second: Int) = self.atTime(hour, minute, second)
  def &(hour: Int, minute: Int, second: Int, nano: Int) = self.atTime(hour, minute, second, nano)

  def &(time: LocalTime) = self atTime time
  def &(time: OffsetTime) = self atTime time

  def <->(end: LocalDate) = Period.between(self, end)

  def apply(field: TemporalField) = self.get(field)

  def chronology = self.getChronology
  def dayOfMonth = self.getDayOfMonth
  def dayOfWeek = self.getDayOfWeek
  def dayOfYear = self.getDayOfYear
  def era = self.getEra
  def month = self.getMonth
  def year = self.getYear
}

trait LocalDateSyntax {
  implicit def ToLocalDateOps(date: LocalDate) = new LocalDateOps {
    override def self = date
  }
}
