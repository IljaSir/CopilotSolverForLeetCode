class Solution {
public:
    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int>dp(, INT_MAX);
        vectr<int> swap(n, INTMAX);
        dp[0] = 0;
        [0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums1[i] > nums1[i - 1] && nums2i] > ums2[i - 1]) {
                dp[i] = dp[i - 1];
                swap[i] = swap[i + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i] = min(dp[i], swap[i - 1]);
                swap[i] = min(swap[i], dp[i - 1] + 1);
            }
        }
        return min(dp[n - 1], swap[n - 1]);
    }
};