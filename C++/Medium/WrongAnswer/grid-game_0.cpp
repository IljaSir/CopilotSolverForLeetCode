class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        vector<long long> pre(n + 1);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + grid[0][i];
        }
        long long ans = 1e18;
        long long sum = pre[n];
        long long cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += grid[1][i];
            ans = min(ans, max(cur, sum - pre[i + 1]));
        }
        return ans;
    }
};