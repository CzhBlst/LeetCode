import java.math.BigInteger;



/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode curr = result;
        int l1Length = getLength(l1);
        int l2Length = getLength(l2);
        int minFlag = 1;
        int i = 1;
        while(l1.next!=null || l2.next!=null){
            if(l1.next!=null && l2.next!=null){
                curr.val = l1.val + l2.val + curr.val;
            }else if(l1.next==null && minFlag==1){
                curr.val = l1.val + l2.val + curr.val;
                minFlag = 0;
            }else if(l2.next==null && minFlag==1){
                curr.val = l1.val + l2.val + curr.val;
                minFlag = 0;
            }else if(l1.next==null && minFlag==0){
                curr.val = l2.val + curr.val;
            }else if(l2.next==null && minFlag==0){
                curr.val = l1.val + curr.val;
            }
            curr.next = new ListNode();
            if(curr.val >= 10){
                curr.val = curr.val - 10;
                curr.next.val = 1;
            }
            curr = curr.next;
            if(l1.next != null) l1 = l1.next;
            if(l2.next != null) l2 = l2.next;
        }
        if(l1Length > l2Length){
            curr.val = curr.val + l1.val;
        }else if(l2Length > l1Length){
            curr.val = curr.val + l2.val;
        }else{
            curr.val = curr.val + l1.val +l2.val;
        }
        if(curr.val>=10){
            curr.next = new ListNode();
            curr.val = curr.val - 10;
            curr.next.val = 1;
            curr = curr.next;
        }
        return result;
    }
    public int getLength(ListNode listNode){
        int result = 0;
        while(listNode.next!=null){ 
            listNode = listNode.next;
            result++; 
        }
        return result + 1;
    }
}
// @lc code=end

