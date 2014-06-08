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
 * @author Alex Westphal 29/May/2014
 * @version 30/May/2014
 */
package timez.syntax

import java.time.{Month, YearMonth}
import timez.temporal.Amount

trait IntOps extends Ops[Int] {

  def centuries = Amount.Centuries(self)
  def days      = Amount.Days(self)
  def decades   = Amount.Decades(self)
  def hours     = Amount.Hours(self)
  def millennia = Amount.Millennia(self)
  def millis    = Amount.Millis(self)
  def minutes   = Amount.Minutes(self)
  def months    = Amount.Months(self)
  def nanos     = Amount.Nanos(self)
  def seconds   = Amount.Seconds(self)
  def weeks     = Amount.Weeks(self)
  def years     = Amount.Years(self)

  def ~(month: Int) = YearMonth.of(self, month)
  def ~(month: Month) = YearMonth.of(self, month)
}

trait IntSyntax {
  implicit def ToIntOps(x: Int) = new IntOps {
    override def self: Int = x
  }
}
