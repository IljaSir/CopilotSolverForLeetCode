class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        
        int M = grid.size(), N = grid[0].size();
        vector<vector<long>> dpMax(M, vector<long>(N, 0));
        vector<vector<long>> dpMin(M, vector<long>(N, 0));
        dpMax[0][0] = grid[0][0];
        dpMin[0][0] = grid[0][0];
        for(int i = 1; i < M; i++) {
            dpMax[i][0] = dpMax[i - 1][0] * grid[i][0];
            dpMin[i][0] = dpMin[i - 1][0] * grid[i][0];
        }
        for(int j = 1; j < N; j++) {
            dpMax[0][j] = dpMax[0][j - 1] * grid[0][j];
            dpMin[0][j] = dpMin[0][j - 1] * grid[0][j];
        }
        for(int i = 1; i < M; i++) {
            for(int j = 1; j < N; j++) {
                dpMax[i][j] = max(dpMax[i - 1][j] * grid[i][j], max(dpMax[i][j - 1] * grid[i][j], max(dpMin[i - 1][j] * grid[i][j], dpMin[i][j - 1] * grid[i][j])));
                dpMin[i][j] = min(dpMin[i - 1][j] * grid[i][j], min(dpMin[i][j - 1] * grid[i][j], min(dpMax[i - 1][j] * grid[i][j], dpMax[i][j - 1] * grid[i][j])));
            }
        }
        return dpMax[M - 1][N - 1] < 0 ? -1 : dpMax[M - 1][N - 1] % 1000000007;
    }
};