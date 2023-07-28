class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        
        int len = nums.size();
        int maxSum = nums[0];
        int curSum = 0;
        for (int i = 0; i < len; i++) {
            if (curSum > 0) {
                curSum += nums[i];
            } else {
                curSum = nums[i];
            }
            maxSum = max(maxSum, curSum);
        }
        return maxSum;
    }
};