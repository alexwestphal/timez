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
 * @version 29/May/2014
 */
package timez.syntax

import scalaz.syntax.Ops
import java.time.Period
import timez.temporal.Amount.PeriodAmount

trait PeriodOps extends Ops[Period] {

  def +(duration: Period) = self.plus(duration)
  def -(duration: Period) = self.minus(duration)

  def *(scalar: Int) = self.multipliedBy(scalar)

  def unary_- = self.negated
}

trait PeriodSyntax {
  implicit def ToPeriodOps(d: Period) = new PeriodOps {
    override def self: Period = d
  }

  implicit def ToPeriodOps(a: PeriodAmount) = new PeriodOps {
    override def self: Period = a.asPeriod
  }
}