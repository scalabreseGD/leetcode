package weekly

object MaxPointsObtainCards {

  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    var max = cardPoints.take(k).sum
    var i = 1
    var sum: Int = max

    while (i <= k) {
      sum = sum + cardPoints(cardPoints.length - i) - cardPoints(k - i)
      println(s"$sum + ${cardPoints(cardPoints.length - i)} - ${cardPoints(k - i)} = $sum")
      max = Math.max(sum, max)
      i += 1
    }
    max
  }


  def main(args: Array[String]): Unit = {
    println(maxScore(cardPoints = Array(32, 69, 37, 79, 4, 33, 29, 33, 45, 1, 99, 90, 56, 24, 76), k = 10))
    //println(maxScore2(cardPoints = Array(1, 2, 3, 4, 5, 6, 1), k = 3))
  }
}
