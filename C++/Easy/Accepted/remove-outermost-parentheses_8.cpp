class Solution {
public:
    string removeOuterParentheses(string s) {
        
        int n = s.length();
        int l = 0;
        string res = "";
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                ++l;
                if (l > 1) res += s[i];
            } else {
                --l;
                if (l > 0) res += s[i];
            }
        }
        return res;
    }
};