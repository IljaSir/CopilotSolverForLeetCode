class Solution {
    public int calculate(String s) {
        
        int n = s.length();
        int num = 0;
        char sign = '+';
        int pre = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
                switch (sign) {
                    case '+':
                        res += pre;
                        pre = num;
                        break;
                    case '-':
                        res += pre;
                        pre = -num;
                        break;
                    case '*':
                        pre *= num;
                        break;
                    case '/':
                        pre /= num;
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        res += pre;
        return res;
    }
}