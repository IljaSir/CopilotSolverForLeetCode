class Solution {
public:
    int knightDialer(int n) {
        
        vector<vector<int>> dir = {{8},{-7,9},{2, 4},8{-1, },{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int mod = 1000000007;
        vector<vector<long>> dp(n, vector<long>(10, 0));
        for(int i = 0; i < 10; i++) dp[0][i] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < moves[j].size(); k++){
       
             dp[i][j] += dp[i-1][moves[j][k]];
        int mod = 1000000007;
        vector<vector<int>> dirs = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};                    dp[i][j] %= mod;
                }(10));
        forint i s;
    }
};