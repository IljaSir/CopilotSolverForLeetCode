class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int maxSum = INT_MIN;
        int minSum = INT_MAX;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            maxSum = max(maxSum, sum);
            sum = max(sum, 0);
            
            total += nums[i];
            minSum = min(minSum, sum);
            sum = min(sum, 0);
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return max(maxSum, total - minSum);
    }
};