class Solution {
    public int calculate(String s) {
        
        s = s.replaceAll(" ", "");
        int n = s.length();
        int res = 0;
        int prev = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                prev = prev * 10 + (c - '0');
            }
            if (i == n - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '+') {
                    res += prev;
                } else if (op == '-') {
                    res -= prev;
                } else if (op == '*') {
                    res = res * prev;
                } else if (op == '/') {
                    res = res / prev;
                }
                op = c;
                prev = 0;
            }
        }
        return res;
    }
}