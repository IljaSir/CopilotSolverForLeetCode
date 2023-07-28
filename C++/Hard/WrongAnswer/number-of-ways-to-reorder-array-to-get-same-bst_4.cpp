class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        vector<vector<int>> dp2(n, vector<int>(n, -1));
        function<int(int, int)> dfs = [&](int l, int r) {
            if (l >= r) return 1;
            if (dp[l][r] != -1) return dp[l][r];
            int res = 0;
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] > nums[l]) {
                    res += dfs(l + 1, i - 1) * dfs(i, r);
                    res %= 1000000007;
                }
            }
            return dp[l][r] = res;
        };
        function<int(int, int)> dfs2 = [&](int l, int r) {
            if (l >= r) return 1;
            if (dp2[l][r] != -1) return dp2[l][r];
            int res = 0;
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] < nums[l]) {
                    res += dfs2(l + 1, i - 1) * dfs2(i, r);
                    res %= 1000000007;
                }
            }
            return dp2[l][r] = res;
        };
        int res = dfs(0, n - 1) + dfs2(0, n - 1) - 1;
        return res < 0 ? res + 1000000007 : res;
    }
};