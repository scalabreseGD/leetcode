package daily.week2

object FloodFill {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val correctColor = image(sr)(sc)
    val (l, w) = (image.length, image(0).length)

    def fillInternal(row: Int, col: Int): Unit = {
      if (row >= 0 && col >= 0 && row != l && col != w && image(row)(col) == correctColor) {
        image(row)(col) = newColor
        fillInternal(row - 1, col)
        fillInternal(row + 1, col)
        fillInternal(row, col - 1)
        fillInternal(row, col + 1)
      }
    }

    if (newColor != correctColor) fillInternal(sr, sc)
    image
  }

  def printImage(image: Array[Array[Int]]) = {
    val resString = image.map(row => s"[${row.mkString(",")}]").mkString("\n")
    println(resString)
  }

  def main(args: Array[String]): Unit = {
    val res = floodFill(image = Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1)),
      sr = 1, sc = 1, newColor = 2)
    printImage(res)
    val imagetwo = floodFill(image = Array(Array(0, 0, 0), Array(0, 1, 1)),
      sr = 1, sc = 1, newColor = 1)
    printImage(imagetwo)
    //      [[0,0,0],[0,1,1]]
    //    1
    //    1
    //    1

  }
}
