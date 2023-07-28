class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        for (int i = 0; i < m; i++) {
            int r = i;
            int c = 0;
            vector<int> tmp;
            while (r < m && c < n) {
                tmp.push_back(mat[r][c]);
                r++;
                c++;
            }
            sort(tmp.begin(), tmp.end());
            r = i;
            c = 0;
            int j = 0;
            while (r < m && c < n) {
                mat[r][c] = tmp[j];
                r++;
                c++;
                j++;
            }
        }
        for (int i = 1; i < n; i++) {
            int r = 0;
            int c = i;
            vector<int> tmp;
            while (r < m && c < n) {
                tmp.push_back(mat[r][c]);
                r++;
                c++;
            }
            sort(tmp.begin(), tmp.end());
            r = 0;
            c = i;
            int j = 0;
            while (r < m && c < n) {
                mat[r][c] = tmp[j];
                r++;
                c++;
                j++;
            }
        }
        return mat;
    }
};