class Solution {
public:
    int countBinarySubstrings(string s) {
        
        int res = 0;
        int pre = 0, cur = 1;
        for (int i = 1; i < s.size(); ++i) {
            if (s[i] == s[i - 1]) {
                ++cur;
            } else {
                res += min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        return res + min(pre, cur);
    }
};