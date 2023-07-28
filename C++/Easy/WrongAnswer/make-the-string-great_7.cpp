class Solution {
public:
    string makeGood(string s) {
        
        stack<char> stk;
        for (char c : s) {
            if (stk.empty() || stk.top() != c) {
                stk.push(c);
            } else {
                stk.pop();
            }
        }
        string ans = "";
        while (!stk.empty()) {
            ans = stk.top() + ans;
            stk.pop();
        }
        return ans;
    }
};