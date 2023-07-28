class Solution {
public:
    int getLengthOfOptimalCompression(string s, int k) {
        
        int n = s.size();
        vector<vector<int>> dp(n+1, vector<int>(k+1, n));
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int& ans = dp[i+1][j];
                ans = dp[i][j] + 1;
                if (j < k) {
                    ans = min(ans, dp[i][j+1]);
                }
                int cnt = 1;
                for (int l = i+1; l < n; l++) {
                    if (s[i] == s[l]) {
                        cnt++;
                    }
                    int del = l - i + 1 - cnt;
                    if (del <= j) {
                        int cur = dp[i][j-del] + 1;
                        if (cnt >= 100) {
                            cur++;
                        }
                        if (cnt >= 10) {
                            cur++;
                        }
                        ans = min(ans, cur);
                    }
                }
            }
        }
        return dp[n][k];
    }
};