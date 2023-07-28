class Solution {
    public int minOperationsToFlip(String expression) {
        
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stackOp = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '0') {
                stack.push(0);
            } else if (expression.charAt(i) == '1') {
                stack.push(1);
            } else if (expression.charAt(i) == '(') {
                stackOp.push('(');
            } else if (expression.charAt(i) == ')') {
                while (stackOp.peek() != '(') {
                    int a = stack.pop();
                    int b = stack.pop();
                    char op = stackOp.pop();
                    stack.push(calculate(a, b, op));
                }
                stackOp.pop();
            } else {
                while (!stackOp.isEmpty() && stackOp.peek() != '(') {
                    int a = stack.pop();
                    int b = stack.pop();
                    char op = stackOp.pop();
                    stack.push(calculate(a, b, op));
                }
                stackOp.push(expression.charAt(i));
            }
            i++;
        }
        while (!stackOp.isEmpty()) {
            int a = stack.pop();
            int b = stack.pop();
            char op = stackOp.pop();
            stack.push(calculate(a, b, op));
        }
        return stack.pop();
    }
    
    public int calculate(int a, int b, char op) {
        if (op == '&') {
            return a & b;
        } else if (op == '|') {
            return a | b;
        } else if (op == '^') {
            return a ^ b;
        }
        return -1;
    }
}