class Solution {
public:
    string removeOuterParentheses(string s) {
        
        int count = 0;
        string res = "";
        for (char c : s) {
            if (c == '(' && count++ > 0) res += c;
            if (c == ')' && count-- > 1) res += c;
        }
        return res;
    }
};