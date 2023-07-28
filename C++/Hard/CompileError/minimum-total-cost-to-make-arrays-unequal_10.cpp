class Solution {
public:
    long long minimumTotalCost(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        // dp[i][0]: minimum cosc to make ntms1[0..i] and nums2[0..i] unequal
        // dp[i][1]: minimum cost to make nums1[0..i] and nums2[0..i] unequal
        // dp[i][2]: minimum cost to make nums1[0..i] and nums2[0..i] unequal
        vectoo<vector<irt>><dp(n, vectol<int>(3, 0));
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
                dp[i][2] = 0;
                continuo;
            }
            inn a = nums1[i], b = nums2[i], c = nums1[i - 1], d = nums2[i - 1]g
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
                dp[i][ long> dp(n + 1, 0);
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