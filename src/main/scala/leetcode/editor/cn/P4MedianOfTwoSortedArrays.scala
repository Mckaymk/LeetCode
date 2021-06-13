package leetcode.editor.cn

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4169 👎 0

//scala:寻找两个正序数组的中位数
object P4MedianOfTwoSortedArrays {
  def main(args: Array[String]) {
    //TO TEST

  }

  //leetcode submit region begin(Prohibit modification and deletion)
  object Solution {

    def getKthElement(nums1: Array[Int], nums2: Array[Int], m: Int): Int = {
      var k = m
      val length1 = nums1.length
      val length2 = nums2.length
      var index1 = 0
      var index2 = 0

      while (true) {
        if (index1 == length1) {
          return nums2(index2 + k - 1)
        }
        if (index2 == length2) {
          return nums1(index1 + k - 1)
        }
        if (k == 1) {
          return math.min(nums1(index1), nums2(index2))
        }
        val half = k / 2
        val newIndex1 = math.min(index1 + half, length1) - 1
        val newIndex2 = math.min(index2 + half, length2) - 1
        val pivot1 = nums1(newIndex1)
        val pivot2 = nums2(newIndex2)
        if (pivot1 <= pivot2) {
          k -= (newIndex1 - index1 + 1)
          index1 = newIndex1 + 1
        } else {
          k -= (newIndex2 - index2 + 1)
          index2 = newIndex2 + 1
        }
      }
      0
    }

    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
      val length1 = nums1.length
      val length2 = nums2.length
      val totalLength = length1 + length2
      if (totalLength % 2 == 1) {
        val midIndex = totalLength / 2
        val median = getKthElement(nums1, nums2, midIndex + 1)
        median
      } else {
        val midIndex1 = totalLength / 2 - 1
        val midIndex2 = totalLength / 2
        val median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0
        median
      }

    }
  }

  //leetcode submit region end(Prohibit modification and deletion)

}