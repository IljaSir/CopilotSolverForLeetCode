class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n+1, INT_MAX);
        dp[0] = INT_MIN;
        for (int x : nums) {
            auto it = upper_bound(dp.begin(), dp.end(), x);
            int i = it - dp.begin();
            if (x - dp[i-1] <= dp[i] - x) {
                dp[i] = x;
            }
        }
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if (dp[i] != INT_MAX) {
                res = i;
            }
        }
        return res;
    }
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int sum = 0;
        vector<int> nums3 = nums1;
        sort(nums3.begin(), nums3.end());
        for (int i = 0; i < n; ++i) {
            sum = (sum + abs(nums1[i] - nums2[i])) % 1000000007;
        }
        int res = sum;
        for (int i = 0; i < n; ++i) {
            int x = nums2[i];
            int j = lower_bound(nums3.begin(), nums3.end(), x) - nums3.begin();
            if (j < n) {
                res = min(res, sum - abs(nums1[i] - nums2[i]) + abs(nums3[j] - nums2[i]));
            }
            if (j > 0) {
                res = min(res, sum - abs(nums1[i] - nums2[i]) + abs(nums3[j-1] - nums2[i]));
            }
        }
        return res;
    }
};