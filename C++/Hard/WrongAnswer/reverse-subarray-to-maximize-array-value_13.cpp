class Solution {
public:
    int maxValueAfterReverse(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int maxdiff = 0;
        int mindiff = INT_MAX;
        for (int i = 0; i < n - 1; i++) {
            sum += abs(nums[i] - nums[i + 1]);
            maxdiff = max(maxdiff, max(abs(nums[0] - nums[i + 1]) - abs(nums[i] - nums[i + 1]), abs(nums[n - 1] - nums[i]) - abs(nums[i] - nums[i + 1])));
            mindiff = min(mindiff, min(abs(nums[0] - nums[i + 1]) - abs(nums[i] - nums[i + 1]), abs(nums[n - 1] - nums[i]) - abs(nums[i] - nums[i + 1])));
        }
        return sum + max(0, maxdiff - mindiff);
    }
};