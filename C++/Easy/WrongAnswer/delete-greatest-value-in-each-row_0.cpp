class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sum = 0;
        while (n > 0) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                int maxRow = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > maxRow) {
                        maxRow = grid[i][j];
                    }
                }
                if (maxRow > max) {
                    max = maxRow;
                }
            }
            sum += max;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == max) {
                        grid[i].erase(grid[i].begin() + j);
                        n--;
                        j--;
                    }
                }
            }
        }
        return sum;
    }
    int maximumGain(string s, int x, int y) {
        int sum = 0;
        vector<vector<int>> grid;
        if (x > y) {
            grid = {{1, 2}, {2, 1}};
            sum += deleteGreatestValue(grid);
            grid = {{1, 1}, {1, 1}};
            sum += deleteGreatestValue(grid);
        } else {
            grid = {{1, 1}, {1, 1}};
            sum += deleteGreatestValue(grid);
            grid = {{1, 2}, {2, 1}};
            sum += deleteGreatestValue(grid);
        }
        return sum;
    }
};