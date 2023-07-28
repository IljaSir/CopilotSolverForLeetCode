class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int n = nums.size();
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        for (int i = 1; i < n; i++) {
            maxSoFar = max(maxSoFar + nums[i], nums[i]);
            minSoFar = min(minSoFar + nums[i], nums[i]);
            maxSum = max(maxSum, maxSoFar);
            minSum = min(minSum, minSoFar);
        }
        return maxSum - minSum;
    }
};