class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<long long> dp(k + 1, 0);
        for (int i = 0; i <= k; ++i) {
            dp[i] = LLONG_MIN;
        }
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = min(i + 1, k); j > 0; --j) {
                if (nums1[i] < nums2[i]) {
                    dp[j] = max(dp[j], dp[j - 1] + nums1[i]);
                } else if (nums1[i] > nums2[i]) {
                    dp[j] = max(dp[j], dp[j - 1] + nums2[i]);
                } else {
                    dp[j] = max(dp[j], dp[j - 1] + nums1[i]);
                    dp[j] = max(dp[j], dp[j - 1] + nums2[i]);
                }
            }
        }
        return dp[k];
    }
};