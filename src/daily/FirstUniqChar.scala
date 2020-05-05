package daily

object FirstUniqChar {

  def firstUniqChar(s: String): Int = {
    firstUniqChar568(s)
  }

  def firstUniqChar568(s: String): Int = {
    s.foldLeft(Seq.empty[Int])((acc, comb) => {
      val firstIndex = s.indexOf(comb)
      if (firstIndex == s.lastIndexOf(comb)) acc.+:(firstIndex) else acc
    }).sorted.headOption.getOrElse(-1)
  }

  def firstUniqChar656(s: String): Int = {
    val data2 = s.zipWithIndex
      .groupBy(_._1)
      .foldLeft(Int.MaxValue)((acc, comb) => {
        if (comb._2.length == 1) math.min(acc, comb._2.head._2)
        else acc
      })
    if (data2 == Int.MaxValue) -1 else data2
  }

  def firstUniqChar690(s: String): Int = {
    val data = s.zipWithIndex
      .groupBy(_._1)
      .filter(_._2.length == 1)
      .flatMap(_._2)

    if (data.isEmpty) -1
    else data.foldLeft(Int.MaxValue)((acc, comb) => math.min(acc, comb._2))
  }

  def main(args: Array[String]): Unit = {
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar(""))
  }
}
