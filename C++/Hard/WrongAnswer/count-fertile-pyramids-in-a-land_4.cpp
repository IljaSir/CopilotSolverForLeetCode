class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int k = 1;
                    while(i + k < m && j - k >= 0 && j + k < n) {
                        if(grid[i + k][j - k] == 1 && grid[i + k][j + k] == 1) {
                            k++;
                        } else {
                            break;
                        }
                    }
                    res += k - 1;
                }
            }
        }
        return res;
    }
    int countInversePyramids(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int k = 1;
                    while(i - k >= 0 && j - k >= 0 && j + k < n) {
                        if(grid[i - k][j - k] == 1 && grid[i - k][j + k] == 1) {
                            k++;
                        } else {
                            break;
                        }
                    }
                    res += k - 1;
                }
            }
        }
        return res;
    }
};