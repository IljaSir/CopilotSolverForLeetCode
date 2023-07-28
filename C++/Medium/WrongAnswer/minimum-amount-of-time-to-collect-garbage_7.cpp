class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        int m = garbage[0].length();
        
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));
        dp[0][0] = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(garbage[i-1][j] == 'M'){
                    dp[i][j] = min(dp[i][j], dp[i-1][j] + travel[i-1]);
                }
            }
            for(int j = 0; j < m; j++){
                if(garbage[i-1][j] == 'P'){
                    dp[i][j] = min(dp[i][j], dp[i-1][j] + travel[i-1]);
                }
            }
            for(int j = 0; j < m; j++){
                if(garbage[i-1][j] == 'G'){
                    dp[i][j] = min(dp[i][j], dp[i-1][j] + travel[i-1]);
                }
            }
        }
        
        int ans = INT_MAX;
        for(int j = 0; j < m; j++){
            ans = min(ans, dp[n-1][j]);
        }
        return ans;
    }
};