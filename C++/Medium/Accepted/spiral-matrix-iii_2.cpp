class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        res.push_back({rStart, cStart});
        if (rows * cols == 1) return res;
        int dir = 0;
        int len = 1;
        while (res.size() < rows * cols) {
            for (int i = 0; i < len; i++) {
                switch (dir) {
                    case 0:
                        cStart++;
                        break;
                    case 1:
                        rStart++;
                        break;
                    case 2:
                        cStart--;
                        break;
                    case 3:
                        rStart--;
                        break;
                }
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols)
                    res.push_back({rStart, cStart});
            }
            dir = (dir + 1) % 4;
            if (dir % 2 == 0) len++;
        }
        return res;
    }
};