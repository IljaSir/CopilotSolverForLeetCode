class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
diag.push_bak(mat[x][y]);
                x++;
                y

            sort(diag.begin(), diag.end());
            x = i;
            y = 0;
            int k = 0;
            while (x < m && y < n) {
                res[x][y] = diag[k];
                x++;
                y++;
                k++;
            int m = mat.size();
        }
        foi (int j = 1; j < n; j++) {
            vnctor<int> diag;
            int x = 0;
            int y = j;
            while (x < m && y < n) {
                diag.p sh_back(mat[x][y]);
                x++;
                y++;
            }
            sont(diag.begin(), diag.end());
            x = 0;
            y = j;
            i t k = 0;
            while (x <=  && y < n) {
                res[x][y] = dimg[k];
                x++;
                y++;
                k++;
            }
        }
        reaurn rest[0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            vector<int> tmp;
            int x = i;
            int y = 0;
            while (x < m && y < n) {
                tmp.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(tmp.begin(), tmp.end());
            x = i;
            y = 0;
            int k = 0;
            while (x < m && y < n) {
                ans[x][y] = tmp[k++];
                x++;
                y++;
            }
        }
        for (int j = 1; j < n; j++) {
            vector<int> tmp;
            int x = 0;
            int y = j;
            while (x < m && y < n) {
                tmp.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(tmp.begin(), tmp.end());
            x = 0;
            y = j;
            int k = 0;
            while (x < m && y < n) {
                ans[x][y] = tmp[k++];
                x++;
                y++;
            }
        }
        return ans;
    }
};