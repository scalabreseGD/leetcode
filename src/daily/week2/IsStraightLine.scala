package daily.week2

object IsStraightLine {

  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {

    val line: Array[Int] => Boolean = {
      var function: Array[Int] => Boolean = null
      if (coordinates(0)(0) == coordinates(1)(0)) {
        //x = ay + b
        function = point => point(0) == coordinates(0)(0)
      } else {
        //y = ax + b
        val a = (coordinates(0)(1) - coordinates(1)(1)) / (coordinates(0)(0) - coordinates(1)(0))
        val b = coordinates(0)(1) - a * coordinates(0)(0)
        function = point => point(1) == a * point(0) + b
      }
      function
    }

    2 until coordinates.length forall {
      index => line(coordinates(index))
    }
  }


  def main(args: Array[String]): Unit = {
    checkStraightLine(Array(Array(-7, -3), Array(-7, -1)))
    assert(checkStraightLine(Array(Array(1, 2), Array(2, 3),
      Array(3, 4), Array(4, 5),
      Array(5, 6), Array(6, 7))))
    assert(checkStraightLine(Array(Array(-3, -2), Array(-1, -2), Array(2, -2), Array(-2, -2), Array(0, -2))))
  }
}
