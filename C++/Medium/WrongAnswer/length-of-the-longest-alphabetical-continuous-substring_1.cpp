class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int maxLen = 0, curLen = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (i == 0 || s[i] > s[i - 1]) {
                ++curLen;
            } else {
                maxLen = max(maxLen, curLen);
                curLen = 1;
            }
        }
        return max(maxLen, curLen);
    }
};