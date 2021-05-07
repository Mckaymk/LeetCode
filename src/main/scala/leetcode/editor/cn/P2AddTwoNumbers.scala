package leetcode.editor.cn

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6152 👎 0

object P2AddTwoNumbers {
    def main(args: Array[String]): Unit = {

    }

    class ListNode(_x: Int = 0, _next: ListNode = null) {
        var next: ListNode = _next
        var x   : Int      = _x
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode(_x: Int = 0, _next: ListNode = null) {
     * var next: ListNode = _next
     * var x: Int = _x
     * }
     */
    object Solution {
        def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
            val head = new ListNode(-1)
            var flag = 0
            var p    = head
            var p1   = l1
            var p2   = l2
            while (p1 != null || p2 != null) {
                var tmp = flag
                if (p1 != null) {
                    tmp += p1.x
                    p1 = p1.next
                }
                if (p2 != null) {
                    tmp += p2.x
                    p2 = p2.next
                }
                p.next = new ListNode(tmp % 10)
                p = p.next
                flag = tmp / 10
            }
            if (flag != 0) {
                p.next = new ListNode(flag)
            }
            head.next
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}