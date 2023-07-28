class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int sum = 0, maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (i == nums.size() - 1 || nums[i] >= nums[i+1]) {
                maxSum = max(maxSum, sum);
                sum = 0;
            }
        }
        return maxSum;
    }
};