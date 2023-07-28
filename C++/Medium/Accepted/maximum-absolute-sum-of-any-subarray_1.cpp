class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int sum = 0;
        int maxSum = 0;
        int minSum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = max(maxSum, sum);
            minSum = min(minSum, sum);
        }
        return maxSum - minSum;
    }
};