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

class Pair{
    int index;
    int value;
    Pair(int index, int value){
        this.index = index;
        this.value = value;
    }
}
class Solution {
    
    public int[] nextLargerNodes(ListNode head) {
        Stack<Pair> st = new Stack<>();
        int size =0;
        
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        int[] ans = new int[size];
        Arrays.fill(ans, 0);

        temp = head;
        for(int i=0;i<size;i++){
            while(!st.isEmpty() && st.peek().value<temp.val){
                ans[st.pop().index] = temp.val;
            }
            st.push(new Pair(i,temp.val));
            temp = temp.next;
        }


        return ans;
        
    }
}







