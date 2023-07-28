class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(1<<n, vector<int>(n, INT_MAX));
        return dfs(nums1, nums2, 0, 0, dp);
    }
    
    int dfs(vector<int>& nums1, vector<int>& nums2, int mask, int idx, vector<vector<int>>& dp) {
        if (idx == nums1.size()) return 0;
        if (dp[mask][idx] != INT_MAX) return dp[mask][idx];
        for (int i = 0; i < nums1.size(); i++) {
            if ((mask & (1<<i)) == 0) {
                dp[mask][idx] = min(dp[mask][idx], dfs(nums1, nums2, mask|(1<<i), idx+1, dp) + (nums1[idx] ^ nums2[i]));
            }
        }
        return dp[mask][idx];
    }
};