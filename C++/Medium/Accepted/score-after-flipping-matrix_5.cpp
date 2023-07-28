class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) cnt++;
            }
            cnt = max(cnt, m - cnt);
            ans += (1 << (n - j - 1)) * cnt;
        }
        return ans;
    }
};