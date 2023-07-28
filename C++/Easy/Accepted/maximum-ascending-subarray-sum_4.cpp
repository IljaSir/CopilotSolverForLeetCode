class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                maxSum = std::max(maxSum, sum);
                sum = nums[i];
            }
        }
        maxSum = std::max(maxSum, sum);
        return maxSum;
    }
};