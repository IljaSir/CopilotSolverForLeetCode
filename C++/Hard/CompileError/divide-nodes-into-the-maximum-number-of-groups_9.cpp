class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        for (auto& edge 
        vector<int> dp(1 << n, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            if (dp[mask] == -1) continue;
            int next = mask;
            for (int i = 1; i <= n; ++i) {
                if (mask & (1 << (i - 1))) continue;
                if ((v[i] & mask) == v[i]) {
                    next |= 1 << (i - 1);
                }
            }
            dp[next] = max(dp[next], dp[mask] + 1);
        }
        return dp[(1 << n) - 1];
    }
};