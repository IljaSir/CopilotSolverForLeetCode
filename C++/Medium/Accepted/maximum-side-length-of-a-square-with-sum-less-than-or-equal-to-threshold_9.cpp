class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int rows = mat.size();
        int cols = mat[0].size();
        int maxLen = 0;
        vector<vector<int>> dp(rows+1, vector<int>(cols+1, 0));
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                dp[i][j] = mat[i-1][j-1] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
                int len = min(i, j);
                while(len>maxLen){
                    if(dp[i][j]-dp[i][j-len]-dp[i-len][j]+dp[i-len][j-len]<=threshold){
                        maxLen = len;
                        break;
                    }
                    len--;
                }
            }
        }
        return maxLen;
    }
};