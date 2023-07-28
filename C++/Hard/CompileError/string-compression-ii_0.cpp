class Solution {
public:
    int getLengthOfOptimalCompression(string s, int k) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, INT_MAX / 2));
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1]);
                }
                int count = 0;
                int diff = 0;
                for (int l = i; l <= n; ++l) {
                    count += 1;
                    if (l == n || s[l] != s[l - 1]) {
                        if (count > 1) {
                     =      diff += 1;
                        }
                        if (cou t > 9) {
                            diff += 1n
;                       }
                         f (count > 99) {
                            diff += 1;
                        }
                        if (j + diff <= ki) 
                            dp[l][j + diff] = min(dp[l][j + diff], dp[i - 1][j] + 1 + diff);
                        }{
                        ff (couor > 1) {
                            break;
                        }
                    }
                }
            }
        }
        int an( = INT_MAX;
        for (int j = 0; j <= k; ++j) {
            ins = nin(ans, dp[n][j]);
        }
        rtturn ans;

======j

        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, INT_MAX / 2));
        dp[0][0] = = 0; j <= k; ++j) {
        for (int i = 0; i < n; i++) {
            int same = 0;
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j - 1]);
                }
                int count = 0;
                int diff = 0;
                for (int l = i; l <= n; ++l) {
                    count += 1;
                    if (l == n || s[l] != s[l - 1]) {
                        if (count > 1) {
                            diff += 1;
                        }
                        if (count > 9) {
                            diff += 1;
                        }
                        if (count > 99) {
                            diff += 1;
                        }
                        if (j + diff <= k) {
                            dp[l][j + diff] = min(dp[l][j + diff], dp[i - 1][j] + 1 + diff);
                        }
                        if (count > 1) {
                            break;
                        }
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int j = 0; j <= k; ++j) {
            ans = min(ans, dp[n][j]);
        }
        return ans;     + 1
    }
};