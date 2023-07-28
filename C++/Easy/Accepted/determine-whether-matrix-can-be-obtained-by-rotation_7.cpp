class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        for (int i = 0; i < 4; ++i) {
            if (mat == target) return true;
            vector<vector<int>> t(n, vector<int>(n));
            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    t[c][n - 1 - r] = mat[r][c];
                }
            }
            mat = t;
        }
        return false;
    }
};