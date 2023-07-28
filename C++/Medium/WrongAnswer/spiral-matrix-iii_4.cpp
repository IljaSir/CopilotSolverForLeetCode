class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        res.push_back({rStart, cStart});
        int n = rows * cols;
        int step = 1;
        int i = 0;
        int j = 0;
        int dir = 0;
        while (res.size() < n) {
            if (dir == 0) {
                for (int k = 0; k < step; ++k) {
                    ++i;
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        res.push_back({i, j});
                    }
                }
                ++dir;
            } else if (dir == 1) {
                for (int k = 0; k < step; ++k) {
                    ++j;
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        res.push_back({i, j});
                    }
                }
                ++dir;
                ++step;
            } else if (dir == 2) {
                for (int k = 0; k < step; ++k) {
                    --i;
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        res.push_back({i, j});
                    }
                }
                ++dir;
            } else if (dir == 3) {
                for (int k = 0; k < step; ++k) {
                    --j;
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        res.push_back({i, j});
                    }
                }
                ++dir;
                ++step;
                dir = 0;
            }
        }
        return res;
    }
};