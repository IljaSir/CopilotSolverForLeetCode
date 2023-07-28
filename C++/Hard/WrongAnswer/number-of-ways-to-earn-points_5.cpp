class Solution {
public:
    int waysToReachTarget(int target, vector<vector<int>>& types) {
        
        vector<vector<int>> dp(target+1, vector<int>(types.size()));
        for (int i = 0; i < types.size(); ++i) {
            for (int j = 0; j <= target; ++j) {
                if (j == 0) {
                    dp[j][i] = 1;
                } else {
                    int cur = 0;
                    for (int k = 0; k <= types[i][0]; ++k) {
                        if (j >= k * types[i][1]) {
                            cur = (cur + dp[j-k*types[i][1]][i]) % 1000000007;
                        }
                    }
                    dp[j][i] = cur;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < types.size(); ++i) {
            ans = (ans + dp[target][i]) % 1000000007;
        }
        return ans;
    }
};