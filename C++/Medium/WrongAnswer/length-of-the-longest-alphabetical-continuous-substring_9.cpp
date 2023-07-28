class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int maxLen = 0;
        int len = 0;
        char prev = 0;
        for (char c : s) {
            if (c > prev) {
                len++;
                maxLen = max(maxLen, len);
            } else {
                len = 1;
            }
            prev = c;
        }
        return maxLen;
    }
};