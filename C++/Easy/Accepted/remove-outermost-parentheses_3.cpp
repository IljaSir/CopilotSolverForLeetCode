class Solution {
public:
    string removeOuterParentheses(string s) {
        
        string result = "";
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(' && count++ > 0) result += '(';
            if (s[i] == ')' && count-- > 1) result += ')';
        }
        return result;
    }
};