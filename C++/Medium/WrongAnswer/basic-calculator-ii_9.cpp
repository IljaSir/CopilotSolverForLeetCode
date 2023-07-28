class Solution {
public:
    int calculate(string s) {
        
        int res = 0, n = s.size();
        int i = 0, num = 0;
        char op = '+';
        while (i < n) {
            if (s[i] == ' ') {
                i++;
                continue;
            }
            if (s[i] >= '0' && s[i] <= '9') {
                num = s[i] - '0';
                while (i + 1 < n && s[i + 1] >= '0' && s[i + 1] <= '9') {
                    num = num * 10 + s[i + 1] - '0';
                    i++;
                }
            }
            if (op == '+') {
                res += num;
            } else if (op == '-') {
                res -= num;
            } else if (op == '*') {
                res *= num;
            } else if (op == '/') {
                res /= num;
            }
            op = s[i];
            i++;
        }
        return res;
    }
};