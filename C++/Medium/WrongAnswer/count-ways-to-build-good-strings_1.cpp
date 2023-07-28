class Solution {
public:
    int countGoodStrings(int low, int high, int zero, int one) {
        
        int mod = 1e9 + 7;
        vector<vector<vector<vector<int>>>> dp(2, vector<vector<vector<int>>>(low + 1, vector<vector<int>>(one + 1, vector<int>(zero + 1, -1))));
        return dfs(dp, 0, low, one, zero, high, 0, 0, 0);
    }
    
    int dfs(vector<vector<vector<vector<int>>>> &dp, int pos, int low, int one, int zero, int high, int pre, int cnt0, int cnt1) {
        if (pos == low) {
            return 1;
        }
        if (dp[pre][pos][cnt1][cnt0] != -1) {
            return dp[pre][pos][cnt1][cnt0];
        }
        int res = 0;
        if (cnt0 < zero) {
            res += dfs(dp, pos + 1, low, one, zero, high, 0, cnt0 + 1, cnt1);
            res %= 1000000007;
        }
        if (cnt1 < one) {
            res += dfs(dp, pos + 1, low, one, zero, high, 1, cnt0, cnt1 + 1);
            res %= 1000000007;
        }
        if (pre == 0) {
            res += dfs(dp, pos + 1, low, one, zero, high, 0, cnt0, cnt1);
            res %= 1000000007;
        }
        if (pre == 1) {
            res += dfs(dp, pos + 1, low, one, zero, high, 1, cnt0, cnt1);
            res %= 1000000007;
        }
        return dp[pre][pos][cnt1][cnt0] = res;
    }
};