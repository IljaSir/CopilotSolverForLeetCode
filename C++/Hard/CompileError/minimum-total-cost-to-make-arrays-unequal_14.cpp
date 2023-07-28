class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        // dp[i][0]: minimum cost to make nums1[0..i] and nums2[0..i] unequal
        // dp[i][1]: minimum cost to make nums1[0..i] and nums2[0..i] unequal
        // dp[i][2]: minimum cost to make nums1[0..i] and nums2[0..i] unequal
        vector<vector<int>> dp(n, vector<int>(3, 0));
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
                dp[i][2] = 0;
                continue;
            }
            int a = nums1[i], b = nums2[i], c = nums1[i - 1], d = nums2[i - 1];
            if (a != b) {
                dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + i;
                dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + i;
                dp[i][2] = min(dp[i - 1][2], min(dp[i - 1][0], dp[i - 1][1])) + i;
            } else if (a != c && b != d) {
                dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + i;
                dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + i;
                dp[i][2] = min(dp[i - 1][2], min(dp[i - 1][0], dp[i - 1][1])) + i;
            } else if (a != c) {
                dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + i;
                dp[i][1] = INT_MAX;
                dp[i][2] = min(dp[i - 1][2], min(dp[i - 1][0], dp[i - 1][1])) + i;
            } else if (b != d) {
                dp[i][
    }
};