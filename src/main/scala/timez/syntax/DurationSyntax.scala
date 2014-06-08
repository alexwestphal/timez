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

import java.time.Duration
import java.time.temporal.TemporalUnit
import timez.temporal.Amount.DurationAmount

trait DurationOps extends Ops[Duration] {

  def +(duration: Duration) = self.plus(duration)
  def -(duration: Duration) = self.minus(duration)

  def *(multiplicand: Long) = self.multipliedBy(multiplicand)
  def /(divisor: Long) = self.dividedBy(divisor)

  def unary_- = self.negated

  def apply(field: TemporalUnit) = self.get(field)

  def nano = self.getNano
  def seconds = self.getSeconds
  def units = self.getUnits
}

  trait DurationSyntax {
    implicit def ToDurationOps(duration: Duration) = new DurationOps {
      override def self: Duration = duration
    }

    implicit def ToDurationOps(amount: DurationAmount) = new DurationOps {
      override def self: Duration = amount.asDuration
    }
  }