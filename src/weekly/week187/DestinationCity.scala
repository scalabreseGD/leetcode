package weekly.week187

object DestinationCity {
  def main(args: Array[String]): Unit = {
    val example = List(List("B", "C"), List("D", "B"), List("C", "A"))
    destCity(example)
  }

  def destCity(paths: List[List[String]]): String = {
    val flat = paths.map(e => (e.head, e.tail.head))
    flat.find(elem => !flat.map(_._1).contains(elem._2)).map(_._2).get
  }
}
