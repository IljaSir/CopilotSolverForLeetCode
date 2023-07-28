class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(n + 1, vector<int>(2, 0));
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = dp[i][1] = INT_MAX;
            if (nums1[i - 1] != nums2[i - 1]) {
                dp[i][0] = min(dp[i][0], dp[i - 1][0] + nums1[i - 1] + nums2[i - 1]);
                dp[i][1] = min(dp[i][1], dp[i - 1][1] + nums1[i - 1] + nums2[i - 1]);
            }
            if (nums1[i - 1] != nums2[i - 1] && nums2[i - 1] != nums1[i - 2]) {
                dp[i][0] = min(dp[i][0], dp[i - 1][1] + nums1[i - 1] + nums2[i - 1]);
            }
            if (nums1[i - 1] != nums2[i - 1] && nums1[i - 1] != nums2[i - 2]) {
                dp[i][1] = min(dp[i][1], dp[i - 1][0] + nums1[i - 1] + nums2[i - 1]);
            }
            if (nums1[i - 1] != nums1[i - 2] && nums2[i - 1] != nums2[i - 2]) {
                dp[i][0] = min(dp[i][0], dp[i - 1][1] + nums1[i - 1] + nums2[i - 1]);
                dp[i][1] = min(dp[i][1], dp[i - 1][0] + nums1[i - 1] + nums2[i - 1]);
            }
        }
        int res = min(dp[n][0], dp[n][1]);
        return res == INT_MAX ? -1 : res;
    }
};