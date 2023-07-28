class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int n = nums.size();
        int currMax = nums[0], maxSum = nums[0];
        int currMin = nums[0], minSum = nums[0];
        int totalSum = nums[0];
        for (int i = 1; i < n; i++) {
            currMax = max(currMax + nums[i], nums[i]);
            maxSum = max(maxSum, currMax);
            currMin = min(currMin + nums[i], nums[i]);
            minSum = min(minSum, currMin);
            totalSum += nums[i];
        }
        if (totalSum == minSum) return maxSum;
        return max(maxSum, totalSum - minSum);
    }
};