class Solution {
public:
    int minInsertions(string s) {
        
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
                if (i + 1 < s.size() && s[i + 1] == ')') {
                    i++;
                } else {
                    res++;
                }
            }
        }
        res += left * 2;
        return res;
    }
};