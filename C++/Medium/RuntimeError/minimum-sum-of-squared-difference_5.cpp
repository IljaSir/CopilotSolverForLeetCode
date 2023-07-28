class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        int n = nums1.size();
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<long long> dp(n + 1, 1e18);
        dp[0] = 0;
        for (int i = 1; i <= k1; ++i) {
            vector<long long> ndp(n + 1, 1e18);
            for (int j = 1; j <= n; ++j) {
                ndp[j] = min(ndp[j], ndp[j - 1] + 1LL * (nums1[j - 1] - nums2[0]) * (nums1[j - 1] - nums2[0]));
                ndp[j] = min(ndp[j], dp[j] + 1LL * (nums1[j - 1] - nums2[j - 1]) * (nums1[j - 1] - nums2[j - 1]));
            }
            dp = ndp;
        }
        for (int i = 1; i <= k2; ++i) {
            vector<long long> ndp(n + 1, 1e18);
            for (int j = 1; j <= n; ++j) {
                ndp[j] = min(ndp[j], ndp[j - 1] + 1LL * (nums2[j - 1] - nums1[0]) * (nums2[j - 1] - nums1[0]));
                ndp[j] = min(ndp[j], dp[j] + 1LL * (nums1[j - 1] - nums2[j - 1]) * (nums1[j - 1] - nums2[j - 1]));
            }
            dp = ndp;
        }
        return dp[n];
    }
};