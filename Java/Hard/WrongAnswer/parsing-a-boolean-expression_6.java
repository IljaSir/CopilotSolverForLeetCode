class Solution {
    public boolean parseBoolExpr(String expression) {
        
        Stack<Boolean> stack = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == 't') {
                stack.push(true);
            } else if (c == 'f') {
                stack.push(false);
            } else if (c == '(') {
                continue;
            } else if (c == ')') {
                if (op.peek() == '&') {
                    boolean b = true;
                    while (!stack.isEmpty() && stack.peek() != null) {
                        b &= stack.pop();
                    }
                    stack.pop();
                    stack.push(b);
                    op.pop();
                } else if (op.peek() == '|') {
                    boolean b = false;
                    while (!stack.isEmpty() && stack.peek() != null) {
                        b |= stack.pop();
                    }
                    stack.pop();
                    stack.push(b);
                    op.pop();
                } else if (op.peek() == '!') {
                    stack.push(!stack.pop());
                    op.pop();
                }
            } else if (c == '&' || c == '|' || c == '!') {
                stack.push(null);
                op.push(c);
            }
        }
        return stack.pop();
    }
}