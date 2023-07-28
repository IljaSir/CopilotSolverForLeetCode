class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<long long> dp(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            vector<long long> ndp(n + 1, 1e18);
            for (int j = 0; j <= n; ++j) {
                if (j != nums1[i] && j != nums2[i]) {
                    ndp[j] = min(ndp[j], dp[j] + i);
                }
                if (nums1[i] != nums2[i]) {
                    ndp[nums1[i]] = min(ndp[nums1[i]], dp[j] + i);
                    ndp[nums2[i]] = min(ndp[nums2[i]], dp[j] + i);
                }
            }
            dp = ndp;
        }
        long long ans = 1e18;
        for (int i = 0; i <= n; ++i) {
            ans = min(ans, dp[i]);
        }
        return ans == 1e18 ? -1 : ans;
    }
};