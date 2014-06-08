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
package timez.syntax

import java.time.{MonthDay, Month, Year}
import java.time.temporal.TemporalField

trait YearOps extends Ops[Year] {

  def &(day: Int) = self.atDay(day)
  def &(month: Month) = self.atMonth(month)
  def &(monthDay: MonthDay) = self.atMonthDay(monthDay)

  def apply(field: TemporalField) = self.get(field)

  def value = self.getValue
}

trait YearSyntax {

  implicit def ToYearOps(year: Year) = new YearOps {
    override def self = year
  }
}
