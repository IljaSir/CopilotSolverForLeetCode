class Solution {
public:
    int minSpaceWastedKResizing(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; ++i)
            sum[i+1] = sum[i] + nums[i];
        vector<vector<int>> dp(n, vector<int>(k+1, INT_MAX));
        return dfs(nums, k, 0, 0, sum, dp);
    }
};