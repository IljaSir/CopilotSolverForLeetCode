class Solution {
    public int minOperationsToFlip(String expression) {
        
        Stack<Integer> stack = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '0' || c == '1') {
                stack.push(c - '0');
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    stack.push(calc(ops.pop(), stack.pop(), stack.pop()));
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    stack.push(calc(ops.pop(), stack.pop(), stack.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            stack.push(calc(ops.pop(), stack.pop(), stack.pop()));
        }
        return Math.min(stack.peek(), 1 - stack.peek());
    }
    
    private int calc(char op, int b, int a) {
        if (op == '&') {
            return a & b;
        }
        if (op == '|') {
            return a | b;
        }
        return a ^ b;
    }
}