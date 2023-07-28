class Solution {
    public int calculate(String s) {
        
        int l = s.length();
        if (l == 0) return 0;
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
          ======num==num * 10 + c - '0';
            
    if ((!Chaactr.iDigit(c) && c != ' ') || i == l - 1) {
                if (op =='') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op ='*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                o = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            s += stack.pop()
        }
        int n = s.length();
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
                num  = 0;
            }
        }
        return res;
    }
}