class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sum = 0;
        int max = 0;
        vector<int> result;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int l = 0; r - l >= 0 && c - l >= 0 && r + l < m && c + l < n; l++) {
                    sum = 0;
                    for (int i = -l; i <= l; i++) {
                        sum += grid[r - l][c + i];
                        sum += grid[r + l][c + i];
                    }
                    for (int i = -l + 1; i <= l - 1; i++) {
                        sum += grid[r + i][c - l];
                        sum += grid[r + i][c + l];
                    }
                    if (sum > max) {
                        max = sum;
                        result.push_back(sum);
                        sort(result.begin(), result.end(), greater<int>());
                        if (result.size() > 3) {
                            result.pop_back();
                        }
                    }
                }
            }
        }
        return result;
    }
};