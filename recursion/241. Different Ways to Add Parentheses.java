// 241. Different Ways to Add Parentheses

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // Traverse through the expression to find operators
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the current character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Recursively divide into left and right subexpressions
                List<Integer> leftPart = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightPart = diffWaysToCompute(expression.substring(i + 1));
                
                // Combine the results of left and right parts based on the current operator
                for (int left : leftPart) {
                    for (int right : rightPart) {
                        int val = 0;
                        if (c == '+') {
                            val = left + right;
                        } else if (c == '-') {
                            val = left - right;
                        } else if (c == '*') {
                            val = left * right;
                        }
                        result.add(val);
                    }
                }
            }
        }
        
        // Base case: if the expression is a pure number, return it as an integer
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
}