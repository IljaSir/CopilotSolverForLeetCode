class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> res(n, 0);
        for (int i = 0; i < n; i++) {
            int r = 0, c = i;
            while (r < m) {
                if (grid[r][c] == 1) {
                    if (c == n - 1 || grid[r][c + 1] == -1) {
                        res[i] = -1;
                        break;
                    } else {
                        c++;
                    }
                } else {
                    if (c == 0 || grid[r][c - 1] == 1) {
                        res[i] = -1;
                        break;
                    } else {
                        c--;
                    }
                }
                r++;
            }
            if (r == m) {
                res[i] = c;
            }
        }
        return res;
    }
};