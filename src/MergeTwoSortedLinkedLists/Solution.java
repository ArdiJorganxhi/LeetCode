package MergeTwoSortedLinkedLists;

import java.util.List;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
             if(list1 == null) {
                return list2;
            } else {
                return list1;
            }
        }
        int val1 = list1.val;
        int val2 = list2.val;

        if(val1 > val2) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}
