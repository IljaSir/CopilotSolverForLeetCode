class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ret = 0;
        for (int i = 0; i < m; i++) {
            ret += grid[i][0] ? 0 : 1 << (n - 1);
        }
        for (int j = 1; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += grid[i][j] ? 1 : 0;
            }
            ret += max(cnt, m - cnt) << (n - j - 1);
        }
        return ret;
    }
};