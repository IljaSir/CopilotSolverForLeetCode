class Solution {
public:
    int connectTwoGroups(vector<vector<int>>& cost) {
        
        int n = cost.size(), m = cost[0].size();
        vector<int> dp(1 << m, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            vector<int> t(1 << m, 0x3f3f3f3f);
            for (int j = 0; j < (1 << m); j++) {
                for (int k = 0; k < m; k++) {
                    if ((j >> k) & 1) {
                        t[j] = min(t[j], dp[j ^ (1 << k)] + cost[i][k]);
                    } else {
                        t[j] = min(t[j], dp[j] + cost[i][k]);
                    }
                }
            }
            dp = t;
        }
        return dp[(1 << m) - 1];
    }
};