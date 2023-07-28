class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int max1 = = 1; i < n; i++) {
            sum += abs(nums[i] - nums[i - 1]);
        }
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                maxDiff = max(maxDiff, abs(nums[0] - nums[i]) - abs(nums[i] - nums[i - 1]));
            }
            if (i < n - 1) {
                maxDiff = max(maxDiff, abs(nums[n - 1] - nums[i]) - abs(nums[i + 1] - nums[i]));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxDiff = max(maxDiff, abs(nums[i] - nums[j]) - abs(nums[i] - nums[i + 1]) - abs(nums[j] - nums[j - 1]) + abs(nums[j] - nums[i + 1]) + abs(nums[i] - nums[j - 1]));
            } maxdiff - mindiff);
    }
};