package progfun

import java.io._
import scala.io.Source

object CourseraData extends Utilities {

  private val lines = Source.fromFile("dat/reactive-jan2014.tsv").getLines.toList

  val users: List[User] = lines.tail.map { line =>
    val xs = line.split("\t").toList
    User(
      xs(1),           // age
      xs(24),          // gender
      xs(23),          // country
      xs(2),           // degree, can be "other" & optionally filled in by user
      xs(3),           // field of study, can be "other" & optionally filled in by user
      xs(4) == "Yes",  // finishedCourse?
      xs(5),           // years programming
      xs(8).toInt,     // was the course worth it?
      xs(19),          // what interested in you in taking the course?
      xs(20),          // where do you plan to apply what you have learned?
      xs(10),          // what is your preferred editor in general? can be "other"
      xs(11),          // what editor did you use in the course? can be "other"
      Odersky(
        xs(6),         // time spent per week working on course - ODSERSKY SEGMENT
        xs(7).toInt,   // difficulty of course - ODSERSKY SEGMENT
        xs(21).toInt   // difficulty of homeworks (programming assignments) - ODSERSKY SEGMENT
      ),
      Meijer(
        xs(27),          // time spent per week working on course - MEIJER SEGMENT
        xs(25).toInt,    // difficulty of course - MEIJER SEGMENT
        xs(29).toInt     // difficulty of homeworks (programming assignments) - MEIJER SEGMENT
      ),
      Kuhn(
        xs(28),          // time spent per week working on course - KUHN SEGMENT
        xs(26).toInt,    // difficulty of course - KUHN SEGMENT
        xs(30).toInt     // difficulty of homeworks (programming assignments) - KUHN SEGMENT
      ),
      Exp(
        xs(12),        // experience with Java?
        xs(13),        // experience with C/C++/Objective-C?
        xs(14),        // experience with Python or other scripting language?
        xs(15),        // experience with .NET?
        xs(17),        // experience with JavaScript?
        xs(18),        // experience with purely functional languages?
        xs(22)        // experience with Lisp/Scheme dialects?
      )
    )
  }

  val total = users.length

  val didntFinish = users.filter(user => !user.finishedCourse)

  val ages                = users.map(_.age)
  val genders             = users.map(_.gender)
  val countries           = users.map(_.country)
  val degrees             = users.map(_.degree)
  val fields              = users.map(_.field)
  val finishedCourse      = users.map(_.finishedCourse)
  val yearsProg           = users.map(_.yearsProg)
  val worthIt             = users.map(_.worthIt)
  val whatInterestedYou   = users.map(_.whatInterestedYou)
  val whereApply          = users.map(_.whereApply)
  val prefEditor          = users.map(_.prefEditor)
  val courseEditor        = users.map(_.courseEditor)
  val oderskyTimeSpent    = users.map(_.odersky.timeSpent)
  val oderskyDifficulty   = users.map(_.odersky.difficulty)
  val oderskyDifficultyHW = users.map(_.odersky.difficultyHW)
  val meijerTimeSpent     = users.map(_.meijer.timeSpent)
  val meijerDifficulty    = users.map(_.meijer.difficulty)
  val meijerDifficultyHW  = users.map(_.meijer.difficultyHW)
  val kuhnTimeSpent       = users.map(_.kuhn.timeSpent)
  val kuhnDifficulty      = users.map(_.kuhn.difficulty)
  val kuhnDifficultyHW    = users.map(_.kuhn.difficultyHW)
  val javaExp             = users.map(_.programmingExp.java)
  val cExp                = users.map(_.programmingExp.c)
  val pythonExp           = users.map(_.programmingExp.python)
  val dotNetExp           = users.map(_.programmingExp.dotNet)
  val jsExp               = users.map(_.programmingExp.js)
  val funcExp             = users.map(_.programmingExp.func)
  val lispExp             = users.map(_.programmingExp.lisp)

}
