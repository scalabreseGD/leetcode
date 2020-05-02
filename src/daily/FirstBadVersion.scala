package daily

import java.util.concurrent.atomic.AtomicInteger

object FirstBadVersion {


  class VersionControl(limitVersion: Int) {
    var numOfCalls = new AtomicInteger(0)

    def isBadVersion(version: Int): Boolean = {
      numOfCalls.incrementAndGet()
      version >= limitVersion //(version * 80 / 100)
    }
  }

  class Solution2(limitVersion: Int) extends VersionControl(limitVersion) {

    def firstBadVersion(n: Int): Int = {

      def internal(left: Int, right: Int, min: Int): Int = {
        if (left > right) min
        else {
          val mid = left + (right - left) / 2
          if (isBadVersion(mid)) internal(left, mid - 1, mid)
          else internal(mid + 1, right, min)
        }
      }


      internal(0, n, -1)
    }
  }

  def main(args: Array[String]): Unit = {
    val solution2 = new Solution2(800)

    val startTime = System.currentTimeMillis
    println(s"Solution: ${solution2.firstBadVersion(1000)}")
    val end = System.currentTimeMillis
    println(s"Numbre of API requests: ${solution2.numOfCalls}")
    println(s"Time spent: ${end - startTime}")
  }

}
