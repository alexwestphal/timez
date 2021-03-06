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
 * @author Alex Westphal 09/Jun/2014
 * @version 09/Jun/2014
 */
package timez.syntax.time

import java.time.{LocalDate, OffsetTime}
import java.time.temporal.TemporalField

trait OffsetTimeOps extends Ops[OffsetTime] {

  def &(date: LocalDate) = self.atDate(date)

  def apply(field: TemporalField) = self.get(field)

  def hour = self.getHour
  def minute = self.getMinute
  def nano = self.getNano
  def offset = self.getOffset
  def second = self.getSecond
}

trait OffsetTimeSyntax {

  implicit def ToOffsetTimeOps(time: OffsetTime) = new OffsetTimeOps {
    override def self = time
  }
}
