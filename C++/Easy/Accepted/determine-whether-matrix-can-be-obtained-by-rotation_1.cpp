class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        for (int i = 0; i < 4; i++) {
            if (mat == target) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }
    void rotate(vector<vector<int>>& mat) {
        int n = mat.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(mat[i][j], mat[j][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(mat[i].begin(), mat[i].end());
        }
    }
};