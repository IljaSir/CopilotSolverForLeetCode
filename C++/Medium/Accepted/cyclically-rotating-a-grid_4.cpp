class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        const int m = grid.size();
        const int n = grid[0].size();
        int l = 0, r = n - 1, t = 0, b = m - 1;
        while (l < r && t < b) {
            int len = (r - l + 1) * 2 + (b - t - 1) * 2;
            int kk = k % len;
            while (kk--) {
                int tmp = grid[t][l];
                for (int i = l; i < r; i++) grid[t][i] = grid[t][i + 1];
                for (int i = t; i < b; i++) grid[i][r] = grid[i + 1][r];
                for (int i = r; i > l; i--) grid[b][i] = grid[b][i - 1];
                for (int i = b; i > t; i--) grid[i][l] = grid[i - 1][l];
                grid[t + 1][l] = tmp;
            }
            l++;
            r--;
            t++;
            b--;
        }
        return grid;
    }
};