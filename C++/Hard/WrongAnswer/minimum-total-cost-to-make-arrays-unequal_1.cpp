class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(2, vector<int>(n, 0));
        dp[0][0] = 0;
        dp[1][0] = 0;
        for (int i = 1; i < n; ++i) {
            if (nums1[i] == nums2[i]) {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1];
                continue;
            }
            int cost1 = dp[0][i - 1] + i;
            int cost2 = dp[1][i - 1] + i;
            if (nums1[i] != nums1[i - 1] && nums2[i] != nums2[i - 1]) {
                cost1 = min(cost1, dp[1][i - 1] + i);
                cost2 = min(cost2, dp[0][i - 1] + i);
            }
            dp[0][i] = cost1;
            dp[1][i] = cost2;
        }
        return min(dp[0][n - 1], dp[1][n - 1]);
    }
};