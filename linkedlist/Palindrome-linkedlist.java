//  234. Palindrome Linked List

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
class Solution{
    public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode temp  = head;
        while(temp!=null){
            ListNode currp1 = temp.next;
            temp.next = prev;
            prev= temp;
            temp = currp1;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseLinkedList(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while(second!=null){
            if(first.val != second.val){
                reverseLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedList(newHead);
        return true;
    }
}