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
package timez.struct

import java.time.{LocalDate, Month}


object YMD {

  def apply(year: Int, month: Int, dayOfMonth: Int) = LocalDate.of(year, month, dayOfMonth)
  def apply(year: Int, month: Month, dayOfMonth: Int) = LocalDate.of(year, month, dayOfMonth)

  def unapply(date: LocalDate): Option[(Int, Month, Int)] =
    if(null == date) None else Some(date.getYear, date.getMonth, date.getDayOfMonth)
}
