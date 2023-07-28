class Solution {
public:
    bool isValid(string s) {
        
        int len = s.length();
        if (len == 1) return false;
        stack<char> stk;
        for (int i = 0; i < len; i++) {
            if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
                stk.push(s[i]);
            } else {
                if (stk.empty()) return false;
                char c = stk.top();
                if (s[i] == ')' && c != '(') return false;
                if (s[i] == ']' && c != '[') return false;
                if (s[i] == '}' && c != '{') return false;
                stk.pop();
            }
        }
        return stk.empty();
    }
};