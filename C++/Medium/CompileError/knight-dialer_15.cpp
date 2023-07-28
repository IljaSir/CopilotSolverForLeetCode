class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> dp(n, vector<int>(10
            vector<int> tmp(10, 0);
            for (int j = 0; j < 10; ++j) {
                for (int k : dir[j]) {
                    tmp[j] = (tmp[j] + dp[k]) % mod;
                }
            }
            dp = tmp;
        }
        int ans = 0;
        for (int i = 0; i < 10; ++i) ans = (ans + dp[i]) % mod;
        return ans;
    }
};