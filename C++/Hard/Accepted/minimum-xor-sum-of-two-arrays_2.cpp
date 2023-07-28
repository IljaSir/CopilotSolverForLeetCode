class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(1 << n, vector<int>(n, INT_MAX));
        return dfs(nums1, nums2, 0, 0, dp);
    }
    
    int dfs(vector<int>& nums1, vector<int>& nums2, int s, int i, vector<vector<int>>& dp) {
        if (i == nums1.size()) return 0;
        if (dp[s][i] != INT_MAX) return dp[s][i];
        for (int j = 0; j < nums2.size(); ++j) {
            if ((s & (1 << j)) == 0) {
                dp[s][i] = min(dp[s][i], dfs(nums1, nums2, s | (1 << j), i + 1, dp) + (nums1[i] ^ nums2[j]));
            }
        }
        return dp[s][i];
    }
};