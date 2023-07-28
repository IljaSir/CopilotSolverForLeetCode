class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sum = 0;
        while (n > 0) {
            int max = 0;
            vector<int> maxIndex;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        maxIndex.clear();
                        maxIndex.push_back(i);
                        maxIndex.push_back(j);
                    }
                }
            }
            if (maxIndex.size() > 0) {
                sum += max;
                grid[maxIndex[0]].erase(grid[maxIndex[0]].begin() + maxIndex[1]);
                n--;
            } else {
                break;
            }
        }
        return sum;
    }
    int deleteGreatestValue2(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int sum = 0;
        while (n > 0) {
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        maxIndex = i;
                    }
                }
            }
            if (max > 0) {
                sum += max;
                grid[maxIndex].erase(grid[maxIndex].begin() + n - 1);
                n--;
            } else {
                break;
            }
        }
        return sum;
    }
    int deleteGreatestValue3(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int sum = 0;
        while (n > 0) {
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][n - 1] > max) {
                    max = grid[i][n - 1];
                    maxIndex = i;
                }
            }
            if (max > 0) {
                sum += max;
                grid[maxIndex].erase(grid[maxIndex].
    }
};