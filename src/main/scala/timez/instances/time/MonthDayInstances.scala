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

import java.time.MonthDay
import scalaz.Show
import timez.{Parse, Now}
import timez.instances.Instance

trait MonthDayInstances {

  implicit val MonthDayNow = Now.instance(MonthDay.now, MonthDay.now)

  implicit val MonthDayOrder = Instance.fromComparable[MonthDay]

  implicit val MonthDayParse = Parse.instance(MonthDay.parse, MonthDay.parse)

  implicit val MonthDayShow = Show.showA[MonthDay]
}
