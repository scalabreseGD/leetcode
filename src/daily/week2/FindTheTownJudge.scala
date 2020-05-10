package daily.week2

object FindTheTownJudge {

  def findJudge(N: Int, trust: Array[Array[Int]]): Int = {

    if(N == 1) return 1

    val reversedTrusts = trust.map({
      case Array(x, y) => (y, x)
    })

    val majorityTrusted = reversedTrusts.groupBy(_._1).mapValues(_.length).maxBy(_._2)
    if (majorityTrusted._2 >= N - 1
      && reversedTrusts.forall(trusted => trusted._2 != majorityTrusted._1)) majorityTrusted._1
    else -1
  }

  def main(args: Array[String]): Unit = {
    assert(findJudge(N = 2, trust = Array(Array(1, 2))) == 2)
    assert(findJudge(N = 3, trust = Array(Array(1, 3), Array(2, 3))) == 3)
    assert(findJudge(N = 3, trust = Array(Array(1, 3), Array(2, 3), Array(3, 1))) == -1)
    assert(findJudge(N = 3, trust = Array(Array(1, 2), Array(2, 3))) == -1)
    assert(findJudge(N = 4, trust = Array(Array(1, 3), Array(1, 4), Array(2, 3), Array(2, 4), Array(4, 3))) == 3)
  }

}
