class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<long long> dp(k + 1, INT_MIN);
        dp[0] = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1] = max(dp[i + 1], dp[j] + 1LL * nums1[n - 1 - i + j] * nums2[j]);
                dp[i + 1] = max(dp[i + 1], dp[j] + 1LL * nums1[j] * nums2[n - 1 - i + j]);
            }
        }
        return dp[k];
    }
};