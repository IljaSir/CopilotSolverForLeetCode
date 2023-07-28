class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        int ans = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int k = ans+1; k <= min(m-i+1, n-j+1); k++){
                    int sum = dp[i+k-1][j+k-1] - dp[i+k-1][j-1] - dp[i-1][j+k-1] + dp[i-1][j-1];
                    if(sum <= threshold){
                        ans = k;
                    }
                }
            }
        }
        return ans;
    }
};