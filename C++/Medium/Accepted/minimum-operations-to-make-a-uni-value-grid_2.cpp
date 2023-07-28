class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> v;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v.push_back(grid[i][j]);
            }
        }
        sort(v.begin(), v.end());
        int median = v[(m * n) / 2];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = abs(grid[i][j] - median);
                if (diff % x != 0) {
                    return -1;
                }
                res += diff / x;
            }
        }
        return res;
    }
};