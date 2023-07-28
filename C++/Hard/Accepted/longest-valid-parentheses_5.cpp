class Solution {
public:
    int longestValidParentheses(string s) {
        
        stack<int> stk;
        int maxLen = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                stk.push(i);
            } else {
                if (!stk.empty() && s[stk.top()] == '(') {
                    stk.pop();
                    maxLen = max(maxLen, i - (stk.empty() ? -1 : stk.top()));
                } else {
                    stk.push(i);
                }
            }
        }
        return maxLen;
    }
};