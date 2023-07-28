class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int n = s.size();
        int maxLen = 0;
        int len = 1;
        for (int i = 1; i < n; ++i) {
            if (s[i] == s[i - 1] + 1) {
                ++len;
            } else {
                maxLen = max(maxLen, len);
                len = 1;
            }
        }
        maxLen = max(maxLen, len);
        return maxLen;
    }
};