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

import java.time.Duration
import scalaz._
import timez.Parse
import timez.instances.Instance

trait DurationInstances {

  implicit val DurationMonoid = Monoid.instance[Duration](_.plus(_), Duration.ZERO)

  implicit val DurationOrder = Instance.fromComparable[Duration]

  implicit val DurationParse = Parse.instance(Duration.parse)

  implicit val DurationShow = Show.showA[Duration]
}
