class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int n = nums1.size();
        vector<long long> dp(k+1, 0);
        for (int i = 0; i < k; ++i) {
            vector<long long> ndp(k+1, 0);
            for (int j = 0; j <= i; ++j) {
                ndp[j] = max(ndp[j], dp[j] + nums1[i-j]);
                ndp[j+1] = max(ndp[j+1], dp[j] + nums2[n-1-j]);
            }
            swap(ndp, dp);
        }
        return *max_element(dp.begin(), dp.end());
    }
};