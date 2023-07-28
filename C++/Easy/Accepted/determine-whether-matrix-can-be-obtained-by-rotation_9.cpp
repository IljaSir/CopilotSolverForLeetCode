class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        int m = mat[0].size();
        int i, j, k;
        for (k = 0; k < 4; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    if (mat[i][j] != target[i][j]) {
                        break;
                    }
                }
                if (j != m) {
                    break;
                }
            }
            if (i == n && j == m) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }
    
    void rotate(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = i; j < m; j++) {
                swap(mat[i][j], mat[j][i]);
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m / 2; j++) {
                swap(mat[i][j], mat[i][m - j - 1]);
            }
        }
    }
};