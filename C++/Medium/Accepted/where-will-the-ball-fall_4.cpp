class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> ans(n, -1);
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            while (x < m) {
                if (grid[x][y] == 1 && y + 1 < n && grid[x][y + 1] == 1) {
                    x++;
                    y++;
                } else if (grid[x][y] == -1 && y - 1 >= 0 && grid[x][y - 1] == -1) {
                    x++;
                    y--;
                } else {
                    break;
                }
            }
            if (x == m) {
                ans[i] = y;
            }
        }
        return ans;
    }
};