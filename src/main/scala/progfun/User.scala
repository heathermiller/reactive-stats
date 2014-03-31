package progfun

/** Survey responses for a single user registered for the course.
 */
case class User(
  age: String,
  gender: String,
  country: String,
  degree: String,
  field: String,
  finishedCourse: Boolean,
  yearsProg: String,
  worthIt: Int,
  whatInterestedYou: String,
  whereApply: String,
  prefEditor: String,
  courseEditor: String,
  odersky: Odersky,
  meijer: Meijer,
  kuhn: Kuhn,
  programmingExp: Exp
) {
  val timeSpent = ""
  val difficulty = Math.round((odersky.difficulty + meijer.difficulty + kuhn.difficulty)/3).toInt
  val difficultyHW = Math.round((odersky.difficultyHW + meijer.difficultyHW + kuhn.difficultyHW)/3).toInt
}

case class Odersky(
  timeSpent: String,
  difficulty: Int,
  difficultyHW: Int
)

case class Meijer(
  timeSpent: String,
  difficulty: Int,
  difficultyHW: Int
)

case class Kuhn(
  timeSpent: String,
  difficulty: Int,
  difficultyHW: Int
)

case class Exp(
  java: String,
  c: String,
  python: String,
  dotNet: String,
  js: String,
  func: String,
  lisp: String
)
