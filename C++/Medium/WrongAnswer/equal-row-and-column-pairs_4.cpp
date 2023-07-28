class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (grid[i][j] == grid[k][l] && i != k && j != l) {
                            count++;
                        }
                    }
                }
            }
        }
        return count / 2;
    }
};