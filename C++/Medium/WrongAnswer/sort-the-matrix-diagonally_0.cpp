class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        for (int i = 0; i < m; i++) {
            sort(mat[i].begin(), mat[i].end());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i, l = j;
                vector<int> tmp;
                while (k < m && l < n) {
                    tmp.push_back(mat[k][l]);
                    k++;
                    l++;
                }
                sort(tmp.begin(), tmp.end());
                k = i; l = j;
                int idx = 0;
                while (k < m && l < n) {
                    mat[k][l] = tmp[idx];
                    k++;
                    l++;
                    idx++;
                }
            }
        }
        return mat;
    }
};