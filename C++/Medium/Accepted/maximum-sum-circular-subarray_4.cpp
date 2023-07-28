class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int n = nums.size();
        int maxSum = INT_MIN;
        int minSum = INT_MAX;
        int totalSum = 0;
        int currMax = 0;
        int currMin = 0;
        for (int i = 0; i < n; i++) {
            currMax = max(currMax + nums[i], nums[i]);
            maxSum = max(maxSum, currMax);
            currMin = min(currMin + nums[i], nums[i]);
            minSum = min(minSum, currMin);
            totalSum += nums[i];
        }
        if (totalSum == minSum) {
            return maxSum;
        }
        return max(maxSum, totalSum - minSum);
    }
};