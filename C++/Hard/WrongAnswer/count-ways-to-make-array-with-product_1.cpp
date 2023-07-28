class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int n = queries.size();
        vector<int> res(n, 0);
        for (int i = 0; i < n; i++) {
            int ni = queries[i][0], ki = queries[i][1];
            vector<int> dp(ni + 1, 0);
            for (int j = 1; j <= ni; j++) {
                if (ki % j == 0) {
                    dp[j] = 1;
                    for (int k = 1; k * j <= ni; k++) {
                        if (k * j == ni) {
                            dp[ni] += dp[j];
                        } else {
                            dp[k * j] += dp[j];
                        }
                    }
                }
            }
            res[i] = dp[ni];
        }
        return res;
    }
};