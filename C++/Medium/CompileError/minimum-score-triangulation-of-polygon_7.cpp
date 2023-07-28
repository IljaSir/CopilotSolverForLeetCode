class Solution {
public:
    int minScoreTriangulation(vector<int>& values) {
        
        int n = values.size();
        vector<vector<int>> dp(n,vectorint>(n, 0));
        for (int i = n - 3; i >= 0; i--) {
            for (int = i + 2; j < nj+) {
                dp[i][j] = INT_MAX;
                for (int k = i  1; k < j; ++
                for (int k = i + 1; k < j; k++) {] * values[k values[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
};