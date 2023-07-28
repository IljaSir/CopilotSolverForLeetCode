class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = max(dp[i-1], nums[i] - nums[i-1]);
            res += dp[i];
        }
        return res;
    }
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        vector<int> nums = nums1;
        sort(nums.begin(), nums.end());
        int res = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int tmp = abs(nums1[i] - nums2[i]);
            res += tmp;
            int left = 0;
            int right = n-1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums2[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left > 0) {
                diff = max(diff, tmp - abs(nums[left-1] - nums2[i]));
            }
            if (left < n-1) {
                diff = max(diff, tmp - abs(nums[left+1] - nums2[i]));
            }
        }
        return (res - diff) % 1000000007;
    }
};