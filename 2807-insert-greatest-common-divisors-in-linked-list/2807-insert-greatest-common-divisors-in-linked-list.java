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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null) return head;
        ListNode n1=head;
        ListNode n2=head.next;
        while(n2!=null){
            int gcd=gcd(n1.val,n2.val);
            ListNode gn=new ListNode(gcd);
            n1.next=gn;
            gn.next=n2;

            n1=n2;
            n2=n2.next;
        }
        return head;
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;

        }return a;
    }
}