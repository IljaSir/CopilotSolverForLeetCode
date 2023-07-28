class Solution {
public:
    int longestValidParentheses(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        stack<int> stk;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                stk.push(i);
            } else {
                if (stk.empty()) {
                    stk.push(i);
                } else {
                    if (s[stk.top()] == '(') {
                        stk.pop();
                        res = max(res, i - (stk.empty() ? -1 : stk.top()));
                    } else {
                        stk.push(i);
                    }
                }
            }
        }
        return res;
    }
};