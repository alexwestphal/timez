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
package timez.syntax

import timez.Parse
import java.time.format.DateTimeFormatter

trait ParseOps extends Ops[String] {

  final def parse[T: Parse] = implicitly[Parse[T]].parse(self)
  final def parse[T: Parse](formatter: DateTimeFormatter) = implicitly[Parse[T]].parse(self, formatter)

  final def parse[T](implicit P: Parse[T], formatter: DateTimeFormatter) = P.parse(self, formatter)
}

trait ParseSyntax {
  implicit def ToParseOps(str: String) = new ParseOps {
    override def self: String = str
  }
}
