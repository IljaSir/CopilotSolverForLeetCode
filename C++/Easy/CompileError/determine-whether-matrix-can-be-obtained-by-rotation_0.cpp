class Solution {
public:
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        
        int n = mat.size();
        for (int i = 0; i < 4; ++i) {
            if (mat == target) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }
};