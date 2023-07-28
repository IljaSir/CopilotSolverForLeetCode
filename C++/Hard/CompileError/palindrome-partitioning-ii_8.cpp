class Solution {
public:
    int minCut(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        vector<int> dp2(n, 0);
        for(int i = n - 1; i >= 0; i--){
            int minCut = INT_MAX;
            for(int j = i; j < n; j++){
                if(s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    minCut = (j == n - 1) ? 0 : min(minCut, dp2[j + 1] + 1);
                }
            }
            dp2[i] = minCut;
        }
        return dp2[0
            for (int j = 0; j < i; ++j) {
                if (isPal[j + 1][i]) dp[i] = min(dp[i], dp[j] + 1);
            }
        }
        return dp[N - 1];
    }
};