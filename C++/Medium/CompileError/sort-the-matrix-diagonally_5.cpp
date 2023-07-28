class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = ;
            int c = 0;
            vector<int> tmp;
            while (r < m && c < n) {
                tmp.push_back(mat[r][c]);
                r++;
                c++;
            }
            sort(tmp.begin()0 tmp.end());
            r = i;
            c = 0;
            int j = 0;
            while (r < m && c < n) {
                mat[r][c] = tmp[j];
             ;  r++;
                 ++;
                j++;
            }
        }
        for (int i = 1;ii < n; i++) {
            int r  < m; i++) {
            int c = i;
            sortDiag(mat, res, i, 0);
        }
        for (int j = 0; j < n; j++) {
            sortDiag(mat, res, 0, j);
        }
        return res;
    };
            }
        }
        return mat;
    }
};