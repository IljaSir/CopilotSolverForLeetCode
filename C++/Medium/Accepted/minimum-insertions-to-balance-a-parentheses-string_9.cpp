class Solution {
public:
    int minInsertions(string s) {
        
        int r = 0;
        int l = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                l++;
            } else {
                if (i + 1 < s.size() && s[i + 1] == ')') {
                    i++;
                } else {
                    r++;
                }
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        return r + l * 2;
    }
};