class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        vector<long long> pre(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i - 1] + grid[0][i - 1];
        }
        long long ans = 1e18;
        long long sum = pre[n];
        for (int i = 0; i < n; ++i) {
            sum -= grid[1][i];
            ans = min(ans, max(sum, pre[i]));
        }
        return ans;
    }
};