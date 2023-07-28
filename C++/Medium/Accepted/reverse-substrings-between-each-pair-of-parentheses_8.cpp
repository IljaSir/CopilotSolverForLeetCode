class Solution {
public:
    string reverseParentheses(string s) {
        
        stack<char> stk;
        for (char ch : s) {
            if (ch == ')') {
                string tmp;
                while (stk.top() != '(') {
                    tmp.push_back(stk.top());
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
        string res;
        while (!stk.empty()) {
            res.push_back(stk.top());
            stk.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};