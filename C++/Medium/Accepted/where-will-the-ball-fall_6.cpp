class Solution {
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> ans;
        for (int i = 0; i < n; i++) {
            int col = i;
            for (int row = 0; row < m; row++) {
                if (grid[row][col] == 1) {
                    if (col + 1 < n && grid[row][col + 1] == 1) {
                        col++;
                    } else {
                        ans.push_back(-1);
                        break;
                    }
                } else {
                    if (col - 1 >= 0 && grid[row][col - 1] == -1) {
                        col--;
                    } else {
                        ans.push_back(-1);
                        break;
                    }
                }
                if (row == m - 1) {
                    ans.push_back(col);
                }
            }
        }
        return ans;
    }
};