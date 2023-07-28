class Solution {
public:
    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<int> dp(n, INT_MAX);
        vector<int> swap(n, INT_MAX);
        dp[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp[i] = dp[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i] = min(dp[i], swap[i - 1]);
                swap[i] = min(swap[i], dp[i - 1] + 1);
            }
        }
        return min(dp[n - 1], swap[n - 1]);
    }
};