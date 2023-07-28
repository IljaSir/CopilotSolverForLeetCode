class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int count = 0;
        vector<vector<int>> row(m, vector<int>(n, 0));
        vector<vector<int>> col(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i][j] = 1;
                    col[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int r = 0;
                    int c = 0;
                    for (int k = 0; k < n; k++) {
                        r += row[i][k];
                    }
                    for (int k = 0; k < m; k++) {
                        c += col[k][j];
                    }
                    if (r == 1 && c == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
};