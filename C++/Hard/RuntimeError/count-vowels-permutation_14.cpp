class Solution {
public:
    int countVowelPermutation(int n) {
        
        const int MOD = 1e9 + 7;
        vector<int> dp(5, 1);
        for (int i = 0; i < n - 1; ++i) {
            vector<int> temp(5, 0);
            temp[0] = (dp[1] + dp[2] + dp[4]) % MOD;
            temp[1] = (dp[0] + dp[2]) % MOD;
            temp[2] = (dp[1] + dp[3]) % MOD;
            temp[3] = dp[2];
            temp[4] = (dp[2] + dp[3]) % MOD;
            dp = temp;
        }
        int ans = 0;
        for (int i = 0; i < 5; ++i) {
            ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
};