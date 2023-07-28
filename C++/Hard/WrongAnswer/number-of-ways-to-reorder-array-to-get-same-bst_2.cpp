class Solution {
public:
    int numOfWays(vector<int>& nums) {
        
        int n = nums.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, 0)));
        return dfs(nums, dp, 0, n - 1, 0);
    }
    
    int dfs(vector<int>& nums, vector<vector<vector<int>>>& dp, int l, int r, int left) {
        if (l > r) return 1;
        if (dp[l][r][left] != 0) return dp[l][r][left];
        int res = 0;
        int n = nums.size();
        int mod = 1e9 + 7;
        for (int i = l; i <= r; i++) {
            if (left && nums[i] < nums[l]) continue;
            if (!left && nums[i] > nums[r]) continue;
            int leftNum = dfs(nums, dp, l + 1, i - 1, 1);
            int rightNum = dfs(nums, dp, i + 1, r, 0);
            res += (long)leftNum * rightNum;
            res %= mod;
        }
        return dp[l][r][left] = res;
    }
};