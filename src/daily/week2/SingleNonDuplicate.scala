package daily.week2

object SingleNonDuplicate {
  def singleNonDuplicate(nums: Array[Int]): Int = {
    def find(left: Int, right: Int): Int = {
      if (nums(left) == nums(left + 1)) {
        if (nums(right - 1) == nums(right)) {
          find(left + 2, right - 2)
        } else {
          nums(right)
        }
      } else {
        nums(left)
      }
    }

    if (nums.length > 1) find(0, nums.length - 1)
    else nums(0)
  }

  def main(args: Array[String]): Unit = {
    val size = 10000
    val useCase = (0 until size).flatMap(num => if (num == size / 2) Array(num) else Array(num, num)).toArray
    val start = System.currentTimeMillis
    println(singleNonDuplicate(useCase))
    println(System.currentTimeMillis - start)


    println(singleNonDuplicate(Array(1, 1, 2, 3, 3, 4, 4, 8, 8)))
    println(singleNonDuplicate(Array(3, 3, 7, 7, 10, 11, 11)))
  }
}
