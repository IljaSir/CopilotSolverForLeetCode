class Solution {
    public int minOperationsToFlip(String expression) {
        
        // 1. convert the expression into a postfix expression
        // 2. evaluate the postfix expression
        // 3. return the result
        Stack<Character> stack = new Stack<>();
        List<Character> postfix = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.add(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top == '(') break;
                    postfix.add(top);
                }
            } else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.add(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        Stack<Integer> stack2 = new Stack<>();
        for (char c : postfix) {
            if (Character.isDigit(c)) {
                stack2.push(c - '0');
            } else {
                int b = stack2.pop();
                int a = stack2.pop();
                int res = 0;
                if (c == '&') {
                    res = a & b;
                } else if (c == '|') {
                    res = a | b;
                }
                stack2.push(res);
            }
        }
        return stack2.pop()       cnt--;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }
                int v = minOperationsToFlip(expression.substring(i + 1, j));
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + v);
                i = j;
            }
        }
        return dp[n];
    }
}