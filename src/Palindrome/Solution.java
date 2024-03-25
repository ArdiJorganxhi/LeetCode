package Palindrome;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        String stringedInteger = String.valueOf(x);
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < stringedInteger.length(); i++) {
            list.add(stringedInteger.charAt(i));
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
