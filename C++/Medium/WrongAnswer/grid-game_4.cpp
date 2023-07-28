class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        vector<long long> prefix(n+1, 0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + grid[0][i-1];
        }
        long long res = LONG_MAX;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[1][i];
            res = min(res, max(sum, prefix[n] - prefix[i+1]));
        }
        return res;
    }
};