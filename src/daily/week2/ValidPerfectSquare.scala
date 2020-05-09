package daily.week2

import scala.annotation.tailrec

object ValidPerfectSquare {

  def isPerfectSquare(num: Int): Boolean = {

    @tailrec
    def checkInternalPow(divisor: Double): Boolean = {
      val res: Double = math.pow(divisor, 2)
      if (res == num) true
      else if (res > num) false
      else checkInternalPow(divisor + 1)
    }

    checkInternalPow(1D)
  }


  def main(args: Array[String]): Unit = {
    println(isPerfectSquare(256))
    println(isPerfectSquare(5))
  }
}
