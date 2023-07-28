class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        
        int s = 0;
        int minSum = INT_MAX;
        int maxSum = INT_MIN;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            s += nums[i];
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            maxSum = max(maxSum, sum);
            if (sum > nums[i]) {
                sum = nums[i];
            }
            minSum = min(minSum, sum);
        }
        return max(s - minSum, maxSum);
    }
};