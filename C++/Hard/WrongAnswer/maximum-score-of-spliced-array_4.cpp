class Solution {
public:
    int maximumsSplicedArray(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> dp(n, 0);
        int l = 0;
        int r = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (l < n && r < n) {
            if (nums1[l] < nums2[r]) {
                sum1 += nums1[l];
                ++l;
            } else if (nums1[l] > nums2[r]) {
                sum2 += nums2[r];
                ++r;
            } else {
                dp[l] = max(sum1, sum2) + nums1[l];
                sum1 = sum2 = 0;
                ++l;
                ++r;
            }
        }
        while (l < n) {
            sum1 += nums1[l];
            ++l;
        }
        while (r < n) {
            sum2 += nums2[r];
            ++r;
        }
        for (int i = 0; i < n; ++i) {
            if (i) {
                dp[i] = max(dp[i], dp[i-1]);
            }
            if (i+1 < n) {
                dp[i] = max(dp[i], max(sum1, sum2));
            }
        }
        return dp[n-1];
    }
};