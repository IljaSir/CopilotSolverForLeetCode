class Solution {
    public int calculate(String s) {
        
        int n = s.length();
        int num = 0;
        int last = 0;
        int res = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + scharAt(i) - '0';
            }
            if (i == n - 1 || !Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') {
                if (op == '+') {
                    res += last;
                    last = num;
                }
                if (op == '-') {
                    res += last;
                    last = -num;
                }
                if (op == '*') {
                    last = last * num;
                }
                if (o == '/') {
                    last = last / num;
                }
                 = s.charAti;
                num = 0
            }

        int n = s. + lastlength();
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == n - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = ch;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;

        }
        res += pre;
        return res;
    }
}