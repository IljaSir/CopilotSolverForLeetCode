class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        while (n > 0) {
            int max = 0;
            int index = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        index = i;
                    }
                }
            }
            res += max;
            grid.erase(grid.begin() + index);
            m--;
        }
        return res;
    }
    int deleteGreatestValue2(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        while (n > 0) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
            }
            res += max;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == max) {
                        grid[i].erase(grid[i].begin() + j);
                        break;
                    }
                }
            }
            n--;
        }
        return res;
    }
    int deleteGreatestValue3(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        while (n > 0) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
            }
            res += max;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == max) {
                        for (int k = i; k
    }
};