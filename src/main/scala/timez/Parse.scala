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
package timez

import java.time.format.{DateTimeParseException, DateTimeFormatter}

trait Parse[T] {

  def parse(text: CharSequence): T
  def parse(text: CharSequence, formatter: DateTimeFormatter): T

  def unapply(text: CharSequence) = try Some(parse(text)) catch { case e: DateTimeParseException => None }
}

object Parse {

  @inline def apply[T](implicit P: Parse[T]) = P

  def instance[T](f: CharSequence => T): Parse[T] = new Parse[T] {
    override def parse(text: CharSequence): T = f(text)
    override def parse(text: CharSequence, formatter: DateTimeFormatter): T = f(text)
  }

  def instance[T](f: CharSequence => T, g: (CharSequence, DateTimeFormatter) => T): Parse[T] = new Parse[T] {
    override def parse(text: CharSequence): T = f(text)
    override def parse(text: CharSequence, formatter: DateTimeFormatter): T = g(text, formatter)
  }
}
