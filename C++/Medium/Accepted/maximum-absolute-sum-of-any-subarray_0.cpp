class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int sum = 0;
        int maxSum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            maxSum = max(maxSum, sum);
            minSum = min(minSum, sum);
        }
        return maxSum - minSum;
    }
};