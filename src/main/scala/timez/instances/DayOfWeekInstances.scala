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
package timez.instances

import java.time.DayOfWeek
import scalaz.{Enum, Ordering, Show}
import timez.Parse

trait DayOfWeekInstances {

  implicit val DayOfWeekEnum: Enum[DayOfWeek] = new Enum[DayOfWeek] {
    def order(x: DayOfWeek, y: DayOfWeek) = Ordering.fromInt(x compareTo y)
    def pred(x: DayOfWeek) = x.minus(1)
    def succ(x: DayOfWeek) = x.plus(1)
  }

  implicit val DayOfWeekParse = Parse instance {
    case s: String => DayOfWeek.valueOf(s)
    case s => throw new IllegalArgumentException("Unsupported parse source: "+s.getClass.getName)
  }

  implicit val DayOfWeekShow = Show.showA[DayOfWeek]
}
