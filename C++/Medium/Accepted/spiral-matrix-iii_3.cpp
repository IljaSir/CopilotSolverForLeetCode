class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        vector<vector<int>> res;
        res.push_back({rStart, cStart});
        int len = 0;
        int dir = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        while(res.size() < rows * cols) {
            if(dir == 0 || dir == 2) {
                len++;
            }
            for(int i = 0; i < len; i++) {
                rStart += dx[dir];
                cStart += dy[dir];
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    res.push_back({rStart, cStart});
                }
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }
};