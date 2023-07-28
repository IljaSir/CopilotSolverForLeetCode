class Solution {
public:
    int calculate(string s) {
        
        int result = 0;
        int num = 0;
        char op = '+';
        int n = s.size();
        for (int i = 0; i < n; i++) {
            if (s[i] >= '0') {
                num = num * 10 + s[i] - '0';
            }
            if (s[i] < '0' && s[i] != ' ' || i == n - 1) {
                if (op == '+') {
                    result += num;
                } else if (op == '-') {
                    result -= num;
                } else if (op == '*') {
                    result = result * num;
                } else if (op == '/') {
                    result = result / num;
                }
                num = 0;
                op = s[i];
            }
        }
        return result;
    }
};