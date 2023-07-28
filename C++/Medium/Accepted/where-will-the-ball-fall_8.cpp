class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> res(n);
        for (int i = 0; i < n; ++i) {
            int c = i;
            for (int r = 0; r < m; ++r) {
                if (grid[r][c] == 1) {
                    if (c == n - 1 || grid[r][c + 1] == -1) {
                        c = -1;
                        break;
                    }
                    ++c;
                }
                else {
                    if (c == 0 || grid[r][c - 1] == 1) {
                        c = -1;
                        break;
                    }
                    --c;
                }
            }
            res[i] = c;
        }
        return res;
    }
};