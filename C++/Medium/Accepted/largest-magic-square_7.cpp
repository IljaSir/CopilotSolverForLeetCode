class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> row(n, vector<int>(m+1, 0));
        vector<vector<int>> col(n+1, vector<int>(m, 0));
        vector<vector<int>> diag1(n+1, vector<int>(m+1, 0));
        vector<vector<int>> diag2(n+1, vector<int>(m+1, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i][j+1] = row[i][j] + grid[i][j];
                col[i+1][j] = col[i][j] + grid[i][j];
                diag1[i+1][j+1] = diag1[i][j] + grid[i][j];
                diag2[i+1][j] = diag2[i][j+1] + grid[i][j];
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = ans; k <= min(n-i, m-j); k++) {
                    int sum = row[i][j+k] - row[i][j];
                    bool flag = true;
                    for (int p = 0; p < k; p++) {
                        if (row[i+p][j+k] - row[i+p][j] != sum) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) continue;
                    for (int p = 0; p < k; p++) {
                        if (col[i+k][j+p] - col[i][j+p] != sum) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) continue;
                    if (diag1[i+k][j+k] - diag1[i][j] != sum) continue;
                    if (diag2[i+k][j] - diag2[i][j+k] != sum) continue;
                    ans = k;
                }
            }
        }
        return ans;
    }
};