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
 * @author Alex Westphal 10/Jun/2014
 * @version 10/Jun/2014
 */
package timez.syntax

import java.util.{TimeZone, Date, Locale, Calendar}

trait CalendarOps extends Ops[Calendar] {

  def apply(field: Int) = self.get(field)
  def update(field: Int, value: Int) = self.set(field, value)

  // Getters
  def actualMaximum(field: Int) = self.getActualMaximum(field)
  def actualMinimum(field: Int) = self.getActualMinimum(field)
  def calendarType = self.getCalendarType
  def displayName(field: Int, style: Int, locale: Locale) = self.getDisplayName(field, style, locale)
  def displayNames(field: Int, style: Int, locale: Locale) = self.getDisplayNames(field, style, locale)
  def firstDayOfWeek = self.getFirstDayOfWeek
  def greatestMinimum(field: Int) = self.getGreatestMinimum(field)
  def leastMaximum(field: Int) = self.getLeastMaximum(field)
  def maximum(field: Int) = self.getMaximum(field)
  def minimalDaysInFirstWeek = self.getMinimalDaysInFirstWeek
  def minimum(field: Int) = self.getMinimum(field)
  def time = self.getTimeInMillis
  def millis = self.getTimeInMillis
  def timeZone = self.getTimeZone
  def weeksInWeekYear = self.getWeeksInWeekYear
  def weekYear = self.getWeekYear

  // Setters
  def firstDayOfWeek_=(value: Int) = self.setFirstDayOfWeek(value)
  def lenient_=(lenient: Boolean) = self.setLenient(lenient)
  def minimalDaysInFirstWeek_=(value: Int) = self.setMinimalDaysInFirstWeek(value)
  def time_=(date: Date) = self.setTime(date)
  def millis_=(millis: Long) = self.setTimeInMillis(millis)
  def timeZone_=(value: TimeZone) = self.setTimeZone(value)

}

trait CalendarSyntax {
  implicit def ToCalendarOps(cal: Calendar) = new CalendarOps {
    override def self = cal
  }
}
