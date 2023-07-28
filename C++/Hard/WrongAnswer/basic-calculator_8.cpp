class Solution {
public:
    int calculate(string s) {
        
        int n = s.size();
        vector<int> ops(n, 0);
        int sign = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '+') {
                sign = 1;
            } else if (s[i] == '-') {
                sign = -1;
            } else if (s[i] == '(') {
                ops[i] = sign;
            } else if (s[i] == ')') {
                ops[i] = -sign;
            }
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (isdigit(s[i])) {
                num = num * 10 + (s[i] - '0');
            }
            if (!isdigit(s[i]) && !isspace(s[i]) || i == n - 1) {
                res += ops[i] * num;
                num = 0;
            }
        }
        return res;
    }
};