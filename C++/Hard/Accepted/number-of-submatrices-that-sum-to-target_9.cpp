class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            dp[i][0] = matrix[i][0];
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i][j - 1] + matrix[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                unordered_map<int, int> mp;
                mp[0] = 1;
                int sum = 0;
                for (int k = 0; k < m; ++k) {
                    sum += dp[k][j] - (i > 0 ? dp[k][i - 1] : 0);
                    if (mp.count(sum - target)) {
                        res += mp[sum - target];
                    }
                    mp[sum]++;
                }
            }
        }
        return res;
    }
};