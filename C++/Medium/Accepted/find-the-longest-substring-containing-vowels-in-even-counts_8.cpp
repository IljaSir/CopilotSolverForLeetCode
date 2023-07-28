class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        int n = s.size();
        vector<int> dp(1 << 5, -1);
        dp[0] = 0;
        int res = 0;
        int state = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'a') {
                state ^= 1 << 0;
            } else if (s[i] == 'e') {
                state ^= 1 << 1;
            } else if (s[i] == 'i') {
                state ^= 1 << 2;
            } else if (s[i] == 'o') {
                state ^= 1 << 3;
            } else if (s[i] == 'u') {
                state ^= 1 << 4;
            }
            if (dp[state] >= 0) {
                res = max(res, i + 1 - dp[state]);
            } else {
                dp[state] = i + 1;
            }
        }
        return res;
    }
};