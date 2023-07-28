class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size();
        int m = n/3;
        vector<int> v1(slices.begin(), slices.end()-1);
        vector<int> v2(slices.begin()+1, slices.end());
        return max(maxSum(v1, m), maxSum(v2, m));
    }
    int maxSum(vector<int>& slices, int m){
        int n = slices.size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                dp[i][j] = max(dp[i-1][j], (i-2 >= 0 ? dp[i-2][j-1] : 0) + slices[i-1]);
            }
        }
        return dp[n][m];
    }
};