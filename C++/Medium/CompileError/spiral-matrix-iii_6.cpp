class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        res.push_back({rStart, cStart});
        int x = rStart;
        int y = cStart;
        int n = 0;
        int step = 1;
        while (res.size() < rows * cols) {
            for (int i = 0; i < step; i++) {
                y++;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    res.push_back({x, y});
                }
            }
            for (int i = 0; i <;
            }
            step++;
        }
        return res;
    }
};