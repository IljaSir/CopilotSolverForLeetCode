class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt * 2 < m) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int val = 0;
            for (int j = 0; j < n; j++) {
                val = (val << 1) + grid[i][j];
            }
            ans += val;
        }
        return ans;
    }
};