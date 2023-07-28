class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        for (int i = 0; i < 4; i++) {
            if (mat == target) {
                return true;
            }
            vector<vector<int>> tmp(n, vector<int>(n, 0));
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    tmp[k][n - 1 - j] = mat[j][k];
                }
            }
            mat = tmp;
        }
        return false;
    }
};