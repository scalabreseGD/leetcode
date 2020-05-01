package weekly

object StringSplitMaxScore {

  def maxScore(s: String): Int = {
    assert(2 <= s.length && s.length <= 500)
    assert(s.matches("[0-1]*"))

    def loadCoeff(substring: String, isZero: Boolean): Int = {
      if (isZero) substring.map(elem => if (elem == "0".charAt(0)) 1 else 0).sum
      else substring.map(elem => if (elem == "1".charAt(0)) 1 else 0).sum
    }

    (1 until s.length)
      .map(s.splitAt(_))
      .map(leftRight => {
        val ret = loadCoeff(leftRight._1, isZero = true) + loadCoeff(leftRight._2, isZero = false)
        println(s"$leftRight = $ret")
        ret
      })
      .max
  }

  def main(args: Array[String]): Unit = {
    println(maxScore("011101"))
    println(maxScore("00111"))
    println(maxScore("1111"))
  }

}
