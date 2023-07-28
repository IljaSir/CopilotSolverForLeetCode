class Solution {
public:
    vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        int dir = 0;
        int dx[4] = {0, 1, 0, -1};
        int dy[4] = {1, 0, -1, 0};
        int x = rStart;
        int y = cStart;
        int length = 1;
        vector<vector<int>> res;
        res.push_back({x, y});
        while(res.size() < rows * cols) {
            for(int i = 0; i < length / 2; i++) {
                x += dx[dir];
                y += dy[dir];
                if(x >= 0 && x < rows && y >= 0 && y < cols)
                    res.push_back({x, y});
            }
            dir = (dir + 1) % 4;
            for(int i = 0; i < length / 2; i++) {
                x += dx[dir];
                y += dy[dir];
                if(x >= 0 && x < rows && y >= 0 && y < cols)
                    res.push_back({x, y});
            }
            dir = (dir + 1) % 4;
            length++;
        }
        return res;
    }
};