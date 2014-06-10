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
package timez.instances.time

import java.time.Period
import scalaz._
import scalaz.Ordering
import timez.Parse

trait PeriodInstances {

  implicit val PeriodMonoid: Monoid[Period] = new Monoid[Period] {
    override def zero: Period = Period.ZERO
    override def append(f1: Period, f2: => Period): Period = f1 plus f2
  }

  implicit val PeriodOrder: Order[Period] = new Order[Period] {
    override def order(x: Period, y: Period): Ordering =
      if(x == y) Ordering.EQ else if(x.minus(y).isNegative) Ordering.LT else Ordering.GT
  }

  implicit val PeriodParse: Parse[Period] = Parse.instance(Period.parse)

  implicit val PeriodShow = Show.showA[Period]
}
