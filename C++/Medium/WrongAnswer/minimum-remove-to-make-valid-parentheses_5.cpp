class Solution {
public:
    string minRemoveToMakeValid(string s) {
        
        stack<int> stk;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') stk.push(i);
            if (s[i] == ')') {
                if (!stk.empty() && s[stk.top()] == '(') stk.pop();
                else stk.push(i);
            }
        }
        string ans;
        for (int i = 0; i < s.size(); i++) {
            if (!stk.empty() && i == stk.top()) {
                stk.pop();
                continue;
            }
            ans += s[i];
        }
        return ans;
    }
};