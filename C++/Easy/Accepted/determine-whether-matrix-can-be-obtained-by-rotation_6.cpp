class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        if (n == 1) {
            return mat[0][0] == target[0][0];
        }
        for (int i = 0; i < 4; i++) {
            if (mat == target) {
                return true;
            }
            vector<vector<int>> temp(n, vector<int>(n));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = mat[n - 1 - j][i];
                }
            }
            mat = temp;
        }
        return false;
    }
};