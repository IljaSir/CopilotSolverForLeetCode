class Solution {
public:
    int countBinarySubstrings(string s) {
        
        int n = s.size();
        int ans = 0;
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < n; ++i) {
            if (s[i] == s[i - 1]) {
                ++cur;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                ++ans;
            }
        }
        return ans;
    }
};