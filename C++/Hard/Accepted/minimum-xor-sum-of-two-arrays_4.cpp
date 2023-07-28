class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(n, vector<int>(1<<n, -1));
        return helper(nums1, nums2, dp, 0, 0);
    }
    
    int helper(vector<int>& nums1, vector<int>& nums2, vector<vector<int>> &dp, int i, int mask) {
        int n = nums1.size();
        if (i == n) return 0;
        if (dp[i][mask] != -1) return dp[i][mask];
        int ans = INT_MAX;
        for (int j = 0; j < n; ++j) {
            if ((mask & (1 << j)) == 0) {
                ans = min(ans, (nums1[i] ^ nums2[j]) + helper(nums1, nums2, dp, i + 1, mask | (1 << j)));
            }
        }
        return dp[i][mask] = ans;
    }
};