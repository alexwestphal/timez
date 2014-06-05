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

import java.time._
import scalaz.syntax.Ops
import java.time.temporal.TemporalAmount

trait LocalDateOps extends Ops[LocalDate] {

  def +(amount: TemporalAmount) = self plus amount
  def -(amount: TemporalAmount) = self minus amount

  def &(hour: Int, minute: Int): LocalDateTime = self.atTime(hour, minute)
  def &(hour: Int, minute: Int, second: Int): LocalDateTime = self.atTime(hour, minute, second)
  def &(hour: Int, minute: Int, second: Int, nano: Int): LocalDateTime = self.atTime(hour, minute, second, nano)

  def &(time: LocalTime) = self atTime time
  def &(time: OffsetTime) = self atTime time

  def <->(end: LocalDate) = Period.between(self, end)
}

trait LocalDateSyntax {
  implicit def ToLocalDateOps(date: LocalDate) = new LocalDateOps {
    override def self = date
  }
}
