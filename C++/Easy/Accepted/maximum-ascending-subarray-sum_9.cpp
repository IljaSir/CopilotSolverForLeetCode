class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        
        int n = nums.size(), sum = 0, maxSum = 0;
        for(int i = 0; i < n; i++) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                sum += nums[i];
            }
            else {
                maxSum = max(maxSum, sum);
                sum = nums[i];
            }
        }
        return max(maxSum, sum);
    }
};