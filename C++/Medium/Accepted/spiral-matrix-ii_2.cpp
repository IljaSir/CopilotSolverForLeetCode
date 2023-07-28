class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> res(n, vector<int>(n, 0));
        int x = 0, y = 0, dx = 0, dy = 1;
        for (int i = 1; i <= n * n; ++i) {
            res[x][y] = i;
            if (res[(x + dx + n) % n][(y + dy + n) % n]) {
                int t = dx;
                dx = dy;
                dy = -t;
            }
            x += dx;
            y += dy;
        }
        return res;
    }
};