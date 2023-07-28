class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int maxSum = INT_MIN, minSum = INT_MAX, sum = 0, total = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            maxSum = max(maxSum, sum);
            sum = max(sum, 0);
            total += nums[i];
            minSum = min(minSum, sum);
            sum = min(sum, 0);
        }
        return maxSum > 0 ? max(maxSum, total - minSum) : maxSum;
    }
};