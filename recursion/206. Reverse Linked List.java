// 206. Reverse Linked List

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
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head == null){
//             return null;
//         }

//         if(head.next == null){
//             return head;
//         }

//        ListNode temp = head;
//        ListNode prev = null;
//        while(temp!=null){
//         ListNode curr = temp.next;
//         temp.next = prev;
//         prev = temp;
//         temp = curr;
//        }
//        return prev;
//     }
// }
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        
        while(curr !=null){
            ListNode currp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr =currp1;

        }
        return prev;
    }
}