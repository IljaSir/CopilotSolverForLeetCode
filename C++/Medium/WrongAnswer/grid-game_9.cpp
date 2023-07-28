class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        long long n = grid[0].size();
        vector<long long> preSum(n + 1);
        preSum[0] = 0;
        for (long long i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + grid[1][i];
        }
        long long ans = LLONG_MAX;
        long long sum = 0;
        for (long long i = 0; i < n; i++) {
            ans = min(ans, max(sum, preSum[n] - preSum[i + 1]));
            sum += grid[0][i];
        }
        return ans;
    }
};