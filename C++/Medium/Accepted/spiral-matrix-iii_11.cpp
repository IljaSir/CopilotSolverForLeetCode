class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        int x = cStart;
        int y = rStart;
        int n = 1;
        int m = 0;
        int dir = 0;
        while (res.size() < rows * cols) {
            for (int i = 0; i < n; i++) {
                if (y >= 0 && x >= 0 && y < rows && x < cols) {
                    res.push_back({y, x});
                }
                if (dir == 0) {
                    x++;
                } else if (dir == 1) {
                    y++;
                } else if (dir == 2) {
                    x--;
                } else {
                    y--;
                }
            }
            dir = (dir + 1) % 4;
            if (dir % 2 == 0) {
                n++;
            }
            m++;
        }
        return res;
    }
};