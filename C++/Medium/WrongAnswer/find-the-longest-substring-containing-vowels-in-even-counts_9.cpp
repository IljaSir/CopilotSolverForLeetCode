class Solution {
public:
    int findTheLongestSubstring(string s) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        vector<int> last(1 << 5, -1);
        last[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            if (s[i - 1] == 'a') dp[i] ^= 1 << 0;
            if (s[i - 1] == 'e') dp[i] ^= 1 << 1;
            if (s[i - 1] == 'i') dp[i] ^= 1 << 2;
            if (s[i - 1] == 'o') dp[i] ^= 1 << 3;
            if (s[i - 1] == 'u') dp[i] ^= 1 << 4;
            if (last[dp[i]] != -1) {
                dp[i] = i - last[dp[i]];
            } else {
                last[dp[i]] = i;
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};