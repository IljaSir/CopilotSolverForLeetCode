class Solution {
public:
    int countVowelStrings(int n) {
        
        vector<vector<int>> dp(n+1, vector<int>(5, 0));
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < 5; ++j){
                if(i == 1){
                    dp[i][j] = 1;
                }else{
                    for(int k = j; k < 5; ++k){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < 5; ++i){
            res += dp[n][i];
        }
        return res;
    }
};