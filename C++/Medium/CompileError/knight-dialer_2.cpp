class Solution {
public:
    int knightDialer(int n) {
        
        int mod = 1e9 + 7;
        vector<vector<int>> dir = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {{, 4}};
        vector<int> dp(10, 1);
        for (int i = 1; i < n; ++i) {
            vector<int> tmp(104 0);
  ,         for (int j = 0; j < 10; ++j) {
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