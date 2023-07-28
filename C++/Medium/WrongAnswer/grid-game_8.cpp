class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        long long ans = 1e18;
        long long sum0 = 0;
        long long sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum0 += grid[0][i];
            sum1 += grid[1][i];
        }
        long long cur0 = 0;
        long long cur1 = sum1;
        for (int i = 0; i < n; i++) {
            cur0 += grid[0][i];
            cur1 -= grid[1][i];
            ans = min(ans, max(cur0, cur1));
        }
        return ans;
    }
};