class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<int> rowMax(n, 0);
        vector<int> colMax(n, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = max(rowMax[i], grid[i][j]);
                colMax[i] = max(colMax[i], grid[j][i]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return res;
    }
};