class Solution {
    public String minRemoveToMakeValid(String s) {
        
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (!stack.isEmpty() && chars[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '#';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '#') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}