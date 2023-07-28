class Solution {
public:
    bool canCross(vector<int>& stones) {
        
        int n = stones.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            mp[stones[i]] = i;
        }
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        dp[0][0] = true;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int k = stones[j] - stones[i];
                if (k > j + 1) {
                    break;
                }
                dp[j][k] = (k > 0 && dp[i][k - 1]) || dp[i][k] || (k < j && dp[i][k + 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (dp[n - 1][i]) {
                return true;
            }
        }
        return false;
    }
};