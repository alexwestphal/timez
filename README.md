# Timez

Timez is a Scala wrapper around the Java Date/Time API defined in JSR310. 

It provides Scalaz type class instances and improved syntax for each of the core Date/Time types. It defines additional
type classes specifically relevant to Date/Time support.

## Geting Timez

```
git clone https://github.com/phantomspectre/timez.git
```

## Quick Start

```scala
import scalaz._ Scalaz._
import timez._ Timez._

scala> now[LocalDate]
res0: java.time.LocalDate = 2014-06-06

scala> 2.hours + 3.minutes
res1: java.time.Duration = PT2H3M
```