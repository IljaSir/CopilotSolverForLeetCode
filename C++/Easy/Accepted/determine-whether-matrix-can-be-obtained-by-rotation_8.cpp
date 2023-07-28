class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        vector<vector<int>> temp(n, vector<int>(n));
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = mat[n - j - 1][i];
                }
            }
            if (temp == target) {
                return true;
            }
            mat = temp;
        }
        return false;
    }
};