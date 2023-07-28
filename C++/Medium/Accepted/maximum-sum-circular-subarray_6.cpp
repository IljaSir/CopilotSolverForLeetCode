class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int n = nums.size();
        int maxSum = INT_MIN;
        int minSum = INT_MAX;
        int currMax = 0;
        int currMin = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            currMax = max(nums[i], currMax + nums[i]);
            maxSum = max(maxSum, currMax);
            currMin = min(nums[i], currMin + nums[i]);
            minSum = min(minSum, currMin);
            total += nums[i];
        }
        if(total == minSum) return maxSum;
        return max(maxSum, total - minSum);
    }
};