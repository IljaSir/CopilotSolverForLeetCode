class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += abs(nums[i] - nums[i - 1]);
        }
        int max1 = INT_MIN;
        int max2 = INT_MIN;
        int min1 = INT_MAX;
        int min2 = INT_MAX;
        for (int i = 1; i < n; i++) {
            max1 = max(max1, min(nums[i - 1], nums[i]) - max(nums[i - 1], nums[i]));
            min1 = min(min1, max(nums[i - 1], nums[i]) - min(nums[i - 1], nums[i]));
            max2 = max(max2, abs(nums[0] - nums[i]) - abs(nums[i - 1] - nums[i]));
            min2 = min(min2, abs(nums[i - 1] - nums[n - 1]) - abs(nums[i - 1] - nums[i]));
        }
        return res + max(max1 - min1, max2 - min2);
    }
};