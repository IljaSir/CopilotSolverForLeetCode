class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        long long sum[2] = {0, 0};
        for (int i = 0; i < n; i++) {
            sum[0] += grid[0][i];
            sum[1] += grid[1][i];
        }
        long long ans = sum[1];
        for (int i = 0; i < n; i++) {
            sum[0] -= grid[0][i];
            sum[1] -= grid[1][i];
            ans = min(ans, max(sum[0], sum[1]));
        }
        return ans;
    }
};