package daily

object FirstUniqChar {

  def firstUniqChar(s: String): Int = {
    firstUniqChar604(s)
  }

  def firstUniqChar604(s: String): Int = {
    s.map(char => (s.indexOf(char), s.lastIndexOf(char)))
      .filter(elem => elem._1 != -1 && elem._1 == elem._2)
      .sortBy(_._1)
      .headOption
      .map(_._1).getOrElse(-1)
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
    print(firstUniqChar("loveleetcode"))
  }
}
