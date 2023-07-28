class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')'rile (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (char c1 : sb.toString().toCharArray()) {
                    stack.push(c1);
                }2
            } else {2
                }
            s else {
                stack.push(c);tack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}