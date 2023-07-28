class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {
        
        int mod = 1000000007;
        vector<vector<vector<vector<long long>>>> dp(low + 1, vector<vector<vector<long long>>>(high + 1, vector<vector<long long>>(zero + 1, vector<long long>(one + 1, -1))));
        return dfs(low, high, zero, one, 0, 0, 0, dp) % mod;
    }
    
    long long dfs(int low, int high, int zero, int one, int cur, int len, int last, vector<vector<vector<vector<long long>>>> &dp) {
        if (len > high) return 0;
        if (len >= low && len <= high && zero == 0 && one == 0) return 1;
        if (dp[len][zero][one][last] != -1) return dp[len][zero][one][last];
        
        long long res = 0;
        if (cur == 0) {
            res += dfs(low, high, zero - 1, one, 0, len + 1, 0, dp);
            res += dfs(low, high, zero, one - 1, 1, len + 1, 1, dp);
        } else {
            res += dfs(low, high, zero, one - 1, 1, len + 1, 1, dp);
            if (last == 1) res += dfs(low, high, zero - 1, one, 0, len + 1, 0, dp);
        }
        return dp[len][zero][one][last] = res;
    }
};