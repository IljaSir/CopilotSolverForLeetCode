class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        // 1. calculate the sum of all absolute differences
        // 2. calculate the max difference of two adjacent elements
        // 3. calculate the max difference of two elements from different subarrays
        int sum = 0;
        int maxDiff = 0;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            int diff = abs(nums[i] - nums[i - 1]);
            maxDiff = max(maxDiff, diff);
            sum += diff;
        }
        // calculate the max difference of two elements from different subarrays
        int maxDiff2 = 0;
        for (int i = 1; i < n - 1; i++) {
            maxDiff2 = max(maxDiff2, abs(nums[i + 1] - nums[0]) - abs(nums[i + 1] - nums[i]));
            maxDiff2 = max(maxDiff2, abs(nums[i - 1] - nums[n - 1]) - abs(nums[i - 1] - nums[i]));
        }
        // calculate the max difference of two elements from different subarrays
        // the first element and the last element
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                maxDiff2 = max(maxDiff2, abs(nums[i] - nums[j]) - abs(nums[i + 1] - nums[j - 1]));
            }
        }
        return sum + max(maxDiff, maxDiff2);
    }
};