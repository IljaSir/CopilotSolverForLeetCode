class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        res.push_back({rStart, cStart});
        int r = rStart, c = cStart, step = 1, dir = 0;
        while (res.size() < rows * cols) {
            for (int i = 0; i < step; i++) {
                r += dirs[dir][0];
                c += dirs[dir][1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res.push_back({r, c});
                }
            }
            dir = (dir + 1) % 4;
            if (dir == 0 || dir == 2) {
                step++;
            }
        }
        return res;
    }
};