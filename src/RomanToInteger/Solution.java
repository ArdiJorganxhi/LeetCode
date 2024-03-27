package RomanToInteger;

import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int resultInteger = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && romanMap.get(s.charAt(i + 1)) > romanMap.get(s.charAt(i))) {
                resultInteger += (romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i)));
                i++;
            } else {
                resultInteger += romanMap.get(s.charAt(i));
            }

        }
        return resultInteger;
    }
}
