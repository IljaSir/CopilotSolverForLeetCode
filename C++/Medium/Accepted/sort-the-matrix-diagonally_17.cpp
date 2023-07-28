class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        for (int i = 0; i < m; i++) {
            int r = i, c = 0;
            vector<int> tmp;
            while (r < m && c < n) {
                tmp.push_back(mat[r][c]);
                r++;
                c++;
            }
            sort(tmp.begin(), tmp.end());
            r = i, c = 0;
            for (int j = 0; j < tmp.size(); j++) {
                mat[r][c] = tmp[j];
                r++;
                c++;
            }
        }
        for (int i = 1; i < n; i++) {
            int r = 0, c = i;
            vector<int> tmp;
            while (r < m && c < n) {
                tmp.push_back(mat[r][c]);
                r++;
                c++;
            }
            sort(tmp.begin(), tmp.end());
            r = 0, c = i;
            for (int j = 0; j < tmp.size(); j++) {
                mat[r][c] = tmp[j];
                r++;
                c++;
            }
        }
        return mat;
    }
};