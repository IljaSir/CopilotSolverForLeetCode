class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> res(n, -1);
        for (int i = 0; i < n; ++i) {
            int x = 0, y = i;
            while (x < m) {
                if (grid[x][y] == 1) {
                    if (y < n - 1 && grid[x][y + 1] == 1) {
                        ++y;
                    } else {
                        break;
                    }
                } else {
                    if (y > 0 && grid[x][y - 1] == -1) {
                        --y;
                    } else {
                        break;
                    }
                }
                ++x;
            }
            if (x == m) {
                res[i] = y;
            }
        }
        return res;
    }
};