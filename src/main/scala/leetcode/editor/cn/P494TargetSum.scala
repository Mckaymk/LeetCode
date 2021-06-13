package leetcode.editor.cn

//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 723 👎 0

//scala:目标和
object P494TargetSum {
  def main(args: Array[String]) {
    //TO TEST

    println(Solution.findTargetSumWays(Array(1), 1))

  }

  //leetcode submit region begin(Prohibit modification and deletion)
  object Solution {

    //    def findTargetSumWays(nums: Array[Int], target: Int): Int = {
    //      var count = 0
    //
    //      def dfs(nums: Array[Int], target: Int, index: Int, sum: Int): Unit = {
    //        if (index == nums.length) {
    //          if (sum == target) {
    //            count += 1
    //          }
    //        } else {
    //          dfs(nums, target, index + 1, sum + nums(index))
    //          dfs(nums, target, index + 1, sum - nums(index))
    //        }
    //      }
    //
    //      dfs(nums, target, 0, 0)
    //      count
    //    }
    def findTargetSumWays(nums: Array[Int], target: Int): Int = {
      val sum = nums.sum
      val diff = sum - target
      if (diff < 0 || diff % 2 != 0) {
        return 0
      }
      val n = nums.length
      val neg = diff / 2
      val dp = Array.ofDim[Int](n + 1, neg + 1)
      dp(0)(0) = 1
      for (i <- 1 to n) {
        val num = nums(i - 1)
        for (j <- 0 to neg) {
          dp(i)(j) = dp(i - 1)(j)
          if (j >= num) {
            dp(i)(j) += dp(i - 1)(j - num)
          }
        }
      }
      dp(n)(neg)
    }

  }

  //leetcode submit region end(Prohibit modification and deletion)

}