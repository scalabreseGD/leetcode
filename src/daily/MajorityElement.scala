package daily

object MajorityElement {

  def majorityElement(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    sorted(nums.length / 2)
  }

  def main(args: Array[String]): Unit = {

  }
}
