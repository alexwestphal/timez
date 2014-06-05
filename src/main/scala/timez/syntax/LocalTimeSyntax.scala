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
import java.time.{ZoneOffset, LocalDate, LocalTime}
import java.time.temporal.TemporalAmount

trait LocalTimeOps extends Ops[LocalTime] {

  def +(amount: TemporalAmount) = self plus amount
  def -(amount: TemporalAmount) = self minus amount

  def &(date: LocalDate) = self atDate date
  def &(offset: ZoneOffset) = self atOffset offset
}

trait LocalTimeSyntax {
  implicit def toLocalTimeOps(time: LocalTime) = new LocalTimeOps {
    override def self = time
  }
}
