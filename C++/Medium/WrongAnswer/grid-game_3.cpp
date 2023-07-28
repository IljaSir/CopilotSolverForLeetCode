class Solution {
public:
    long long gridGame(vector<vector<int>>& grid) {
        
        int n = grid[0].size();
        long long sum1 = 0;
        long long sum2 = 0;
        for (int i = 0; i < n; ++i) {
            sum1 += grid[0][i];
            sum2 += grid[1][i];
        }
        long long res = LLONG_MAX;
        long long s1 = 0;
        long long s2 = 0;
        for (int i = 0; i < n; ++i) {
            s1 += grid[0][i];
            s2 += grid[1][i];
            res = min(res, max(sum1 - s1, s2));
        }
        return res;
    }
};