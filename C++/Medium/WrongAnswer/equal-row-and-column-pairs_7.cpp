class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == grid[j][i]) {
                    result++;
                }
            }
        }
        return result;
    }
};