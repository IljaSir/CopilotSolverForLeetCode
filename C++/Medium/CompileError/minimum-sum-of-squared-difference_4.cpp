class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int n = nums1.size();
        vector<int> dp(n + 1);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (nums1[i - 1] - nums2[i - 1]) * (nums1[i - 1] - nums2[i - 1]);
        }
        long long ans = dp[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums1[mid] < nums2[i]) l = mid + 1;
                else r = mid;
            }
            if (l <= i) {
                if (l) ans = min(ans, dp[l - 1] + dp[n] - dp[n - i + l - 1] + 1LL * (i - l + 1) * (nums1[l] - nums2[i]) * (nums1[l] - nums2[i]) + 1LL * (l - i + n - 1) * (nums1[l - 1] - nums2[i]) * (nums1[l - 1] - nums2[i]));
                else ans = min(ans, dp[n] - dp[n - i] + 1LL * (i + 1) * (nums1[l] - nums2[i]) * (nums1[l] - nums2[i]));
            } else {
                if (l < n) ans = min(ans, dp[i] + dp[n] - dp[n - l + i] + 1LL * (l - i) * (nums1[l] - nums2[i]) * (nums1[l] - nums2[i]) + 1LL * (l - i - 1) * (nums1[l - 1] - nums2[i]) * (nums1[l - 1] - nums2[i]));
                else ans = min(ans, dp[i] + 1LL * (l - i) * (nums1[l - 1] - nums2[i]) * (nums1[l - 1] - nums2[i
    }
};