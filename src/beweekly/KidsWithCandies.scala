package beweekly

object KidsWithCandies {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    val max = candies.max
    candies.map(candyChild => candyChild + extraCandies >= max)
  }


}
