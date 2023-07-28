class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int n = pizza.size();
        int m = pizza[0].size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for(int i = n-1; i >= 0; --i) {
            for(int j = m-1; j >= 0; --j) {
                dp[i][j] = (pizza[i][j] == 'A') + dp[i+1][j] + dp[i][j+1] - dp[i+1][j+1];
            }
        }
        int MOD = 1e9+7;
        vector<vector<vector<int>>> memo(n, vector<vector<int>>(m, vector<int>(k+1, -1)));
        return f(0, 0, k, dp, memo) % MOD;
    }
    int f(int i, int j, int k, vector<vector<int>>& dp, vector<vector<vector<int>>>& memo) {
        if(k == 1) {
            return dp[i][j] > 0;
        }
        if(memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        int ans = 0;
        for(int x = i+1; x < dp.size()-1; ++x) {
            if(dp[x][j] > 0) {
                ans += f(x, j, k-1, dp, memo);
            }
        }
        for(int y = j+1; y < dp[0].size()-1; ++y) {
            if(dp[i][y] > 0) {
                ans += f(i, y, k-1, dp, memo);
            }
        }
        return memo[i][j][k] = ans;
    }
};