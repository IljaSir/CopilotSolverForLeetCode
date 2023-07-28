class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> row(n, vector<int>(m, 0));
        vector<vector<int>> col(n, vector<int>(m, 0));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                row[i][j] = (j == 0 ? 1 : row[i][j - 1] + 1);
                col[i][j] = (i == 0 ? 1 : col[i - 1][j] + 1);
            }
        }
        int ans = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                int len = min(row[i][j], col[i][j]);
                while(len > ans) {
                    if(row[i - len + 1][j] >= len && col[i][j - len + 1] >= len) {
                        ans = len;
                        break;
                    }
                    len--;
                }
            }
        }
        return ans * ans;
    }
};