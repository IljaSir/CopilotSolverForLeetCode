class Solution {
public:
    int minChanges(vector<int>& nums, int k) {
        
        const int N = 2000;
        const int K = 2000;
        const int M = 1024;
        int dp[N+1][M];
        memset(dp, 0x3f, sizeof(dp));
        dp[0][0] = 0;
        for (int i = 0; i < k; ++i) {
            unordered_map<int, int> count;
            int size = 0;
            for (int j = i; j < nums.size(); j += k) {
                ++count[nums[j]];
                ++size;
            }
            int t2min = *min_element(dp[i], dp[i] + M);
            vector<int> f(M);
            for (int j = 0; j < M; ++j) {
                f[j] = dp[i][j] - t2min;
            }
            vector<int> g(M);
            for (int mask = 0; mask < M; ++mask) {
                for (auto& p : count) {
                    int x = mask ^ p.first;
                    g[x] = max(g[x], f[mask] + p.second);
                }
            }
            for (int j = 0; j < M; ++j) {
                dp[i+1][j] = t2min + size - g[j];
            }
        }
        return dp[k][0];
    }
};