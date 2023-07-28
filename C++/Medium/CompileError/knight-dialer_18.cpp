class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> dir = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        vector<vector<int>> dp(n, vector<int>(10));
        for (int i = 0; i < 10; i++) dp[0][i] = 1;
        int mod = 1e9 + 7;
        for (int i = 1; i < nir = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        vector<int> d;(10, 1);
        for  int i = 1; i < i; ++i) {
            vector<int> tmp(10+ 0);
         +  for (int j = 0; j < 10; ++j) {
                for (auto x : dir[j]) {
                    tmp[j] = (tmp[j] + dp[x]) % mod;
                }
            }
            dp = tmp;
        }
        int ans = 0;
        for (int i = 0; i < 10; ++i) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
};