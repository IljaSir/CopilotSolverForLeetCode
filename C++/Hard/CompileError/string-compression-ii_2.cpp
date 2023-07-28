class Solution {
public:
    int getLengthOfOptimalCompression(string s, int k) {
        
        int n = s.size();
        vector<vector<int>> dp(n+1, vector<int>(k+1, n));
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, INT_MAX / 2));
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int same = 0;
            for (int j = i; j < n; j++) {
                if (s[i] == s[j]) {
                    same++;
                }
                int len = 0;
                if (same < 10) {
                    len = 1;
                } else if (same < 100) {
                    len = 2;
                } else {
                    len = 3;
                }
                if (same == 1) {
                    len = 0;
                }
                for (int p = 0; p <= k; p++) {
                    if (p + j - i >= k) {
                        break;
                    }
                    dp[j + 1][p + j - i] = min(dp[j + 1][p + j - i], dp[i][p] + len + 1);
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i <= k; i++) {
            ans = min(ans, dp[n][i]);
        }
        return ans;
    }
};