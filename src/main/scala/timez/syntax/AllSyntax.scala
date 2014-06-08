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
package timez.syntax

trait AllSyntax extends DayOfWeekSyntax with DurationSyntax with InstantSyntax with IntSyntax with LocalDateSyntax
  with LocalDateTimeSyntax with LocalTimeSyntax with MonthSyntax with MonthDaySyntax with OffsetDateTimeSyntax
  with OffsetTimeSyntax with ParseSyntax with PeriodSyntax with TemporalSyntax with YearSyntax with YearMonthSyntax
  with ZonedDateTimeSyntax with ZoneIdSyntax with ZoneOffsetSyntax

object AllSyntax extends AllSyntax