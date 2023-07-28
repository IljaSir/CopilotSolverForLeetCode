class Solution {
public:
    int minInsertions(string s) {
        
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                left++;
            } else {
                if (i + 1 < s.size() && s[i + 1] == ')') {
                    i++;
                } else {
                    res++;
                }
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
            }
        }
        return res + left * 2;
    }
};