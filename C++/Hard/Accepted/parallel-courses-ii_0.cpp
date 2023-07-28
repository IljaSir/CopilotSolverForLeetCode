class Solution {
public:
    int minNumberOfSemesters(int n, vector<vector<int>>& relations, int k) {
        
        vector<int> graph(n, 0);
        for (auto& r : relations) {
            graph[r[1] - 1] |= 1 << (r[0] - 1);
        }
        vector<int> dp(1 << n, n);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            int canTake = 0;
            for (int i = 0; i < n; ++i) {
                if (!(mask & (1 << i)) && (mask & graph[i]) == graph[i]) {
                    canTake |= 1 << i;
                }
            }
            for (int sub = canTake; sub; sub = (sub - 1) & canTake) {
                if (__builtin_popcount(sub) <= k) {
                    dp[mask | sub] = min(dp[mask | sub], dp[mask] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};