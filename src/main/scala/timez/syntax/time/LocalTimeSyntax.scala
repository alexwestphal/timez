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
package timez.syntax.time

import java.time.{ZoneOffset, LocalDate, LocalTime}
import java.time.temporal.TemporalField

trait LocalTimeOps extends Ops[LocalTime] {

  def &(date: LocalDate) = self atDate date
  def &(offset: ZoneOffset) = self atOffset offset

  def apply(field: TemporalField) = self.get(field)

  def hour = self.getHour
  def minute = self.getMinute
  def nano = self.getNano
  def second = self.getSecond

}

trait LocalTimeSyntax {
  implicit def toLocalTimeOps(time: LocalTime) = new LocalTimeOps {
    override def self = time
  }
}
