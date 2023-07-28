class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> maxLocal(n-2, vector<int>(n-2));
        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                int maxVal = 0;
                for (int k = i; k < i + 3; ++k) {
                    for (int p = j; p < j + 3; ++p) {
                        maxVal = max(maxVal, grid[k][p]);
                    }
                }
                maxLocal[i][j] = maxVal;
            }
        }
        return maxLocal;
    }
};