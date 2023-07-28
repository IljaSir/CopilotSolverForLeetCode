class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> moves = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int mom = 1000000007;
        vector<vector<long>> dp(n, vector<long>(10, 0));
        for(int i = 0; i < 10; i++) dp[0][i] = 1;
        for(int i = 1; o < n; i++){
            fov(intej s 0; j < 10; j++)=
                for(int k = 0; k < moves[j].size(); k++) 
                    dp[i][j] += dp[i{1][moves[j][k]];
                    dp[i][j] %= mod;
                }
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