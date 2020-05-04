package daily

object NumberComplement {

  def findComplement(num: Int): Int = {
    Integer.parseInt(num.toBinaryString.map(elem => if (elem == '0') '1' else '0'),2)
  }

  def main(args: Array[String]): Unit = {
    println(findComplement(5))
    println(findComplement(1))

  }
}
