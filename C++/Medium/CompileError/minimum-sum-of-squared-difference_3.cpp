class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        int n = nums1.size();
        vector<int> v1 = nums1, v2 = nums2;
        sort(v1.begin(), v1.end());
        sort(v2.begin(), v2.end());
        vector<long long> dp(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (long long)(nums1[i - 1] - nums2[i - 1]) * (nums1[i - 1] - nums2[i - 1]);
        }
        long long ans = dp[n];
        for (int i = 0; i < n; i++) {
            int delta1 = v1[i] - nums1[i];
            int delta2 = nums1[i] - v1[i - 1];
            int delta = min(delta1, delta2);
            if (delta * k1 >= (v1[i] - v1[i - 1])) {
                k1 -= (v1[i] - v1[i - 1]) / delta;
                ans = min(ans, dp[i] + (v1[i] - v1[i - 1]) * (v1[i] - v1[i - 1]) + dp[n] - dp[i + 1]);
            } else {
                ans = min(ans, dp[i] + (long long)k1 * delta * delta + dp[n] - dp[i + 1]);
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            int delta1 = v2[i] - nums2[i];
            int delta2 = nums2[i] - v2[i - 1];
            int delta = min(delta1, delta2);
            if (delta * k2 >= (v2[i] - v2[i - 1])) {
                k2 -= (v2[i] - v2[i - 1]) / delta;
                ans = min(ans, dp[i] + (v2[i] - v2[i - 1]) * (v2[i] - v2[i - 1]) + dp[n] - dp[i + 1]);
            } else {
                ans = min(ans, dp[i] + (long long)k2 * delta * delta + dp[n] -
    }
};