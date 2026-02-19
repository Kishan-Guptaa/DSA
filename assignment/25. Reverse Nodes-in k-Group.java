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
    public ListNode reverseLinkedList(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public ListNode getKthNode(ListNode temp,int k){
        k -= 1;
        while(temp!=null && k>0){
            k = k-1;
            temp = temp.next;
        }
        return temp;
    }   
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode KthNode = getKthNode(temp,k);
            if(KthNode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }
            ListNode nextNode = KthNode.next;
            KthNode.next = null;
            reverseLinkedList(temp);

            if(temp == head){
                head  = KthNode;
            }
            else{
                prev.next = KthNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }
}