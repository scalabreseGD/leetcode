package daily.week1

object RansomNote {

  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    def charCountMap(string: String) = string.groupBy(e => e).mapValues(_.length)

    val magazineOccurrences = charCountMap(magazine)
    val ransomNoteOccurrences = charCountMap(ransomNote)
    ransomNoteOccurrences.forall(note => (magazineOccurrences.getOrElse(note._1, -100) - note._2) >= 0)
  }

  def main(args: Array[String]): Unit = {
    assert(!canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"))
    assert(!canConstruct("a", "b"))
    assert(!canConstruct("aa", "ab"))
    assert(canConstruct("aa", "aab"))
  }
}
