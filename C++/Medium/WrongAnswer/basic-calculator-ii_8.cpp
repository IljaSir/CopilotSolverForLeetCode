class Solution {
public:
    int calculate(string s) {
        
        int n = s.size();
        int sign = 1;
        int res = 0;
        int num = 0;
        stack<int> stk;
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (isdigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stk.push(res);
                stk.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stk.top(); stk.pop();
                res += stk.top(); stk.pop();
            }
        }
        if (num != 0) res += sign * num;
        return res;
    }
};