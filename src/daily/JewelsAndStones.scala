package daily

object JewelsAndStones {
  def numJewelsInStones2(J: String, S: String): Int = {
    J.flatMap(j => S.map(s => if (s == j) 1 else 0)).sum
  }

  def numJewelsInStones(J: String, S: String): Int = {
    S.map(s => if (J.contains(s)) 1 else 0).sum
  }

  def numJewelsInStonesReduce(J: String, S: String): Int = {
    S.foldLeft(0)((acc, s) => if (J.contains(s)) acc + 1 else acc)
  }

  def numJewelsInStonesFor(J: String, S: String): Int = {
    (for {
      j <- J
      s <- S if j == s
    } yield 1).sum
  }

  def main(args: Array[String]): Unit = {
    assert(numJewelsInStones(J = "aA", S = "aAAbbbb") == 3)
    assert(numJewelsInStones(J = "z", S = "ZZ") == 0)
  }
}
