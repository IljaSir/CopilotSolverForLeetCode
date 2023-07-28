class Solution {
    public int minOperationsToFlip(String expression) {
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int res = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                stack.push(res);
                stack2.push(0);
                res = 0;
            } else if (c == ')') {
                res = Math.min(res, stack2.pop() + 1);
                res += stack.pop();
            } else if (c == '&') {
                res = Math.min(res, 1);
            } else if (c == '|') {
                res = Math.min(res, 1);
                stack2.push(res);
                res = 0;
            }
        }
        return res;
    }
}