class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (ch == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}