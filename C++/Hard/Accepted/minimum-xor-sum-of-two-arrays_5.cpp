class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(n, vector<int>(1<<n, 1e9));
        return dfs(nums1, nums2, 0, 0, dp);
    }
    int dfs(vector<int>& nums1, vector<int>& nums2, int i, int mask, vector<vector<int>>& dp) {
        if (i == nums1.size()) return 0;
        if (dp[i][mask] != 1e9) return dp[i][mask];
        for (int j = 0; j < nums2.size(); ++j) {
            if (!(mask & (1 << j))) {
                dp[i][mask] = min(dp[i][mask], (nums1[i] ^ nums2[j]) + dfs(nums1, nums2, i + 1, mask | (1 << j), dp));
            }
        }
        return dp[i][mask];
    }
};