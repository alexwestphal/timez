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
package timez.instances

trait AllInstances extends ClockInstances with DayOfWeekInstances with DurationInstances with InstanceInstances
  with LocalDateInstances with LocalDateTimeInstances with LocalTimeInstances with MonthDayInstances
  with MonthInstances with OffsetDateTimeInstances with OffsetTimeInstances with PeriodInstances
  with YearInstances with ZonedDateTimeInstances with ZonedIdInstances with ZoneOffsetInstances

object AllInstances extends AllInstances