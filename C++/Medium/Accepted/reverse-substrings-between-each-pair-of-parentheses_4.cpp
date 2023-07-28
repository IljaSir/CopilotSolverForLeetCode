class Solution {
public:
    string reverseParentheses(string s) {
        
        stack<int> stk;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                stk.push(i);
            } else if (s[i] == ')') {
                int left = stk.top();
                stk.pop();
                reverse(s.begin() + left + 1, s.begin() + i);
            }
        }
        string ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s[i] != '(' && s[i] != ')') {
                ans += s[i];
            }
        }
        return ans;
    }
};