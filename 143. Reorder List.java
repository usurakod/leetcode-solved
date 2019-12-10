Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

**************************************************************************************************************************************

class Solution {
public void reorderList(ListNode head) {
        if(head==null)
            return;
        
        // find middle point
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){ 
            fast=fast.next.next;
            slow=slow.next;
        }
        
        // half into two lists, and reverse second half 
        ListNode p=slow.next;
        ListNode prev=null;
        while(p!=null){ 
            ListNode tmp=p;
            p=p.next;
            tmp.next=prev;
            prev=tmp;
        }
        slow.next=null;
        
        
        //merge
        ListNode l1=head;
        ListNode l2=prev;
        Boolean flag=true;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        p=dummy;
        while(l1!=null&&l2!=null){ //merge
            if(flag){
                p.next=l1;
                l1=l1.next;
            }
            else{
                p.next=l2;
                l2=l2.next;
            }
            flag=!flag;
            p=p.next;
        }
        if(l1!=null)
            p.next=l1;
        else
            p.next=l2;
    }
}
