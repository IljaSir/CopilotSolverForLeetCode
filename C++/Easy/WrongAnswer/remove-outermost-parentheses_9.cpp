class Solution {
public:
    string removeOuterParentheses(string s) {
        
        string res;
        int i = 0;
        int count = 0;
        for (char c : s) {
            if (c == '(') {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                res += s.substr(i+1, s.size()-i-2);
                i = s.size();
            } else if (i == s.size()) {
                i = s.size() - count;
            }
        }
        return res;
    }
};