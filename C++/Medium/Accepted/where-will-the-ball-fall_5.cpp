class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> ans(n, -1);
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = i;
            while (x < m) {
                if (grid[x][y] == 1) {
                    if (y == n - 1) {
                        break;
                    }
                    if (grid[x][y + 1] == 1) {
                        y++;
                    } else {
                        break;
                    }
                } else {
                    if (y == 0) {
                        break;
                    }
                    if (grid[x][y - 1] == -1) {
                        y--;
                    } else {
                        break;
                    }
                }
                x++;
            }
            if (x == m) {
                ans[i] = y;
            }
        }
        return ans;
    }
};