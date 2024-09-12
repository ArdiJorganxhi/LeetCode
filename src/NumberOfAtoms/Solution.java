package NumberOfAtoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static String countOfAtoms(String formula) {
        Map<String, Integer> atomCounts = new HashMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> insideParentheses = stack.pop();
                i++;
                int start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String atom : insideParentheses.keySet()) {
                    int count = insideParentheses.get(atom);
                    stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + count * multiplier);
                }
            } else {
                int start = i;
                i++;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String element = formula.substring(start, i);
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(element, stack.peek().getOrDefault(element, 0) + count);
            }
        }
        atomCounts = stack.pop();
        StringBuilder formulaBuilder = new StringBuilder();
        atomCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    formulaBuilder.append(entry.getKey());
                    if (entry.getValue() > 1) {
                        formulaBuilder.append(entry.getValue());
                    }
                });

        return formulaBuilder.toString();
    }
}
