class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        
        int m = triangle.size();
        int n = triangle[m-1].size();
        vector<int> dp(n, 0);
        dp[0] = triangle[0][0];
        for(int i = 1; i < m; i++){
            for(int j = i; j >= 0; j--){
                if(j == 0) dp[j] = dp[j] + triangle[i][j];
                else if(j == i) dp[j] = dp[j-1] + triangle[i][j];
                else dp[j] = min(dp[j], dp[j-1]) + triangle[i][j];
            }
        }
        int res = dp[0];
        for(int i = 1; i < n; i++){
            res = min(res, dp[i]);
        }
        return res;
    }
};