package daily

object JewelsAndStones {
  def numJewelsInStones(J: String, S: String): Int = {
    J.flatMap(j => S.map(s => if (s == j) 1 else 0)).sum
  }

  def main(args: Array[String]): Unit = {
    assert(numJewelsInStones(J = "aA", S = "aAAbbbb") == 3)
    assert(numJewelsInStones(J = "z", S = "ZZ") == 0)
  }
}
