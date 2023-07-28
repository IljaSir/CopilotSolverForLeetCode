class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> rowSum(m, vector<int>(n+1, 0));
        vector<vector<int>> colSum(m+1, vector<int>(n, 0));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
                colSum[i+1][j] = colSum[i][j] + grid[i][j];
            }
        }
        int ans = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = min(m-i, n-j); k > ans; k--){
                    int sum = 0;
                    for(int l = 0; l < k; l++){
                        sum += grid[i+l][j+l];
                    }
                    if(sum != rowSum[i][j+k] - rowSum[i][j]) continue;
                    if(sum != colSum[i+k][j] - colSum[i][j]) continue;
                    if(sum != rowSum[i+k-1][j+k] - rowSum[i+k-1][j]) continue;
                    if(sum != colSum[i+k][j+k-1] - colSum[i][j+k-1]) continue;
                    ans = k;
                }
            }
        }
        return ans;
    }
};