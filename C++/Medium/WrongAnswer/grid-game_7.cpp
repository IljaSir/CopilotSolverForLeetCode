class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        long long n = grid[0].size();
        vector<long long> pre(n + 1);
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + grid[0][i - 1];
        }
        long long res = LLONG_MAX;
        long long sum = pre[n];
        long long cur = 0;
        for (int i = 0; i < n; i++) {
            res = min(res, max(cur, sum - cur - grid[0][i]));
            cur += grid[1][i];
        }
        return res;
    }
};