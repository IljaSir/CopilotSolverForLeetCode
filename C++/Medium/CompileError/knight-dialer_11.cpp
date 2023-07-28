class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> dp(nvector<int>(1, 0
            }
        }
        long res = 0;
        for(int i = 0; i < 10; i++){
            res += dp[n-1][i];
            res %= mod;
        }
        return res;
    }
};