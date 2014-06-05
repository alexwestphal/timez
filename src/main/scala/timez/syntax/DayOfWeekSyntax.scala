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
package timez.syntax

import scalaz.syntax.Ops
import java.time.DayOfWeek
import timez.temporal.Amount

trait DayOfWeekOps extends Ops[DayOfWeek] {

  def +(days: Amount.Days) = self.plus(days.amount)
  def -(days: Amount.Days) = self.minus(days.amount)
}

trait DayOfWeekSyntax {

  implicit def ToDayOfWeekOps(day: DayOfWeek) = new DayOfWeekOps {
    override def self: DayOfWeek = day
  }
}
