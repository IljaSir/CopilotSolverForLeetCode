class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        // Sort the diagonals
        for (int i = 0; i < m; i++) {
            vector<int> diag;
            int x = i;
            int y = 0;
            while (x < m && y < n) {
                diag.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(diag.begin(), diag.end());
            x = i;
            y = 0;
            int k = 0;
            while (x < m && y < n) {
                res[x][y] = diag[k];
                x++;
                y++;
                k++;
            }
        }
        for (int j = 1; j < n; j++) {
            vector<int> diag;
            int x = 0;
            int y = j;
            while (x < m && y < n) {
                diag.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(diag.begin(), diag.end());
            x = 0;
            y = j;
            int k = 0;
            while (x < m && y < n) {
                res[x][y] = diag[k];
                x++;
                y++;
                k++;
            }
        }
        return res;
    }
};