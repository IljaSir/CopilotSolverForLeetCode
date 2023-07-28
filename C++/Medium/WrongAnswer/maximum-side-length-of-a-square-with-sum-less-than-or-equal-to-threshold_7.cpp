class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                dp[i][j] = mat[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        int ans = 0;
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                int left = 0;
                int right = min(m-i, n-j)+1;
                while(left < right){
                    int mid = left + (right-left)/2;
                    int sum = dp[i+mid-1][j+mid-1] - dp[i+mid-1][j-1] - dp[i-1][j+mid-1] + dp[i-1][j-1];
                    if(sum <= threshold){
                        left = mid+1;
                    }
                    else{
                        right = mid;
                    }
                }
                ans = max(ans, left-1);
            }
        }
        return ans;
    }
};