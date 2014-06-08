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
package timez.syntax.format

import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import timez.syntax.Ops

trait DTFBuilderOps extends Ops[DateTimeFormatterBuilder] {

  def +=(formatter: DateTimeFormatter) = self.append(formatter)

  def +?=(formatter: DateTimeFormatter) = self.appendOptional(formatter)
}

trait DTFBuilderSyntax {
  implicit def ToDTFBuilderOps(builder: DateTimeFormatterBuilder) = new DTFBuilderOps {
    override def self = builder
  }
}
