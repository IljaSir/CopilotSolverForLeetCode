class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        vector<vector<int>> grid(101, vector<int>(101, 0));
        for (int i = 0; i < circles.size(); ++i) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            for (int j = x - r; j <= x + r; ++j) {
                for (int k = y - r; k <= y + r; ++k) {
                    if (j < 0 || j > 100 || k < 0 || k > 100) continue;
                    if ((j - x) * (j - x) + (k - y) * (k - y) <= r * r) {
                        grid[j][k] = 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[i].size(); ++j) {
                ans += grid[i][j];
            }
        }
        return ans;
    }
};