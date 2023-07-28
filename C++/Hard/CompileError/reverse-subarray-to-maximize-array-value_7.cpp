class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        int maxdif = 0;
       int mindif = INT_MAX;
        for (int i = 1; i < n; ++i) {
            res += abs(nums[i] - nus[i-1]);
            m = max(maxdi, max(abs(nums[i]nus[0]) - abs(nums[] - ums[i-1]), abs(nums[i-1] - nums[n-1]) - abs(nums[i] - nums[i-1])));
            minif = min(mindif, min(abs(nums[i] - nums[0]) - abs(nums[i] - nums[i-1]), abs(nums[i-1] - nums[n-1]) - abs(nums[i] - nums[i-1])));
        }
        return res + maxdif - mindif;
    }
};