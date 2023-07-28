class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                for (int k = 0; k < grid.size(); k++) {
                    if (grid[i][j] == grid[k][j] && grid[i][j] == grid[i][k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
};