
// GFG
class Solution {
    public ArrayList<Integer> printList(Node head) {
        // code here
        Node temp = head;
        ArrayList<Integer>ans = new ArrayList<>();
        while(temp!=null){
            ans.add(temp.data);
            temp = temp.next;
        }
        return ans;
    }
}