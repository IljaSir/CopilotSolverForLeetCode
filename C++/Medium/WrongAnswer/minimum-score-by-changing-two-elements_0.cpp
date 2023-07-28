class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            res += abs(nums[i] - nums[i + 1]);
        }
        return res;
    }
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int res = 0;
        int sum = 0;
        vector<int> nums = nums1;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            int diff = abs(nums1[i] - nums2[i]);
            res = max(res, diff - abs(nums2[i] - *lower_bound(nums.begin(), nums.end(), nums2[i])));
            sum = (sum + diff) % 1000000007;
        }
        return (sum - res) % 1000000007;
    }
};