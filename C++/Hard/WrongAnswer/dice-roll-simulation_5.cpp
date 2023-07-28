class Solution {
public:
    int dieSimulator(int n, vector<int>& rollMax) {
        
        int MOD = 1000000007;
        vector<int> dp(6, 1);
        vector<int> dp2(6, 0);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 6; ++j) {
                dp2[j] = 0;
                for (int k = 0; k < 6; ++k) {
                    if (j == k) {
                        if (rollMax[j] > dp[k]) {
                            dp2[j] = (dp2[j] + dp[k]) % MOD;
                        }
                    } else {
                        dp2[j] = (dp2[j] + dp[k]) % MOD;
                    }
                }
            }
            swap(dp, dp2);
        }
        return accumulate(dp.begin(), dp.end(), 0) % MOD;
    }
};