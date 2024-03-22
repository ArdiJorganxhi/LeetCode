package PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int last = list.size() - 1;
        for(int i = 0; i <= list.size() / 2; i++) {
            if(list.get(i) != list.get(last)) {
                return false;
            }
            last--;
        }
        return true;
    }
}
