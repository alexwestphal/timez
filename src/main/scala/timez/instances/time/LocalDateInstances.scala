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
package timez.instances.time

import java.time.LocalDate
import scalaz.{Ordering, Order, Show}
import timez.{Parse, Now}

trait LocalDateInstances {

  implicit val LocalDateNow = Now.instance(LocalDate.now, LocalDate.now)

  implicit val LocaDateOrder = Order order { (x: LocalDate, y: LocalDate) => Ordering.fromInt(x compareTo y) }

  implicit val LocalDateParse = Parse.instance(LocalDate.parse, LocalDate.parse)

  implicit val LocalDateShow = Show.showA[LocalDate]
}
