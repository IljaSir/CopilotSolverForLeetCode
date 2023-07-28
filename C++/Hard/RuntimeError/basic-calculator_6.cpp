class Solution {
public:
    int calculate(string s) {
        
        stack<int> stk;
        int sign = 1;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ') continue;
            if (s[i] == '+') {
                sign = 1;
            } else if (s[i] == '-') {
                sign = -1;
            } else if (s[i] == '(') {
                stk.push(ans);
                stk.push(sign);
                ans = 0;
                sign = 1;
            } else if (s[i] == ')') {
                ans = ans * stk.top();
                stk.pop();
                ans += stk.top();
                stk.pop();
            } else {
                int num = 0;
                while (i < n && isdigit(s[i])) {
                    num = num * 10 + s[i] - '0';
                    i++;
                }
                i--;
                ans += sign * num;
            }
        }
        return ans;
    }
};