class Solution {
public:
    string reverseParentheses(string s) {
        
        stack<char> stk;
        for (char ch : s) {
            if (ch == ')') {
                string tmp;
                while (!stk.empty() && stk.top() != '(') {
                    tmp += stk.top();
                    stk.pop();
                }
                stk.pop();
                for (char c : tmp) {
                    stk.push(c);
                }
            } else {
                stk.push(ch);
            }
        }
        string ans;
        while (!stk.empty()) {
            ans += stk.top();
            stk.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};