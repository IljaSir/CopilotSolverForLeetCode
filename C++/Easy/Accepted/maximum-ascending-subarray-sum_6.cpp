class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int maxSum = 0;
        int curSum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                curSum += nums[i];
            } else {
                maxSum = max(maxSum, curSum);
                curSum = nums[i];
            }
        }
        maxSum = max(maxSum, curSum);
        return maxSum;
    }
};