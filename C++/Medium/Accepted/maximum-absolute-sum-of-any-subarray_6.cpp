class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int n = nums.size();
        int maxSum = 0, minSum = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = max(maxSum, sum);
            minSum = min(minSum, sum);
        }
        return maxSum - minSum;
    }
};