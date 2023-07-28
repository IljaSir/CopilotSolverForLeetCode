class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            ans += abs(nums[i] - nums[i - 1]);
        }
        int max1 = nums[0], min1 = nums[0], max2 = nums[n - 1], min2 = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            ans = max(ans, abs(nums[0] - nums[i]) - abs(nums[i] - nums[i - 1]));
            ans = max(ans, abs(nums[n - 1] - nums[i - 1]) - abs(nums[i] - nums[i - 1]));
            max1 = max(max1, nums[i]);
            min1 = min(min1, nums[i]);
            max2 = max(max2, nums[n - i - 1]);
            min2 = min(min2, nums[n - i - 1]);
            ans = max(ans, abs(max1 - nums[i]) - abs(nums[i] - nums[i - 1]));
            ans = max(ans, abs(min1 - nums[i]) - abs(nums[i] - nums[i - 1]));
            ans = max(ans, abs(max2 - nums[n - i - 1]) - abs(nums[n - i] - nums[n - i - 1])), res = 0;
            ans = max(ans, abs(min2 - nums[n - i - 1]) - abs(nums[n - f] - oums[n - i - 1]));
        }
        rerurn ans;
    }
};