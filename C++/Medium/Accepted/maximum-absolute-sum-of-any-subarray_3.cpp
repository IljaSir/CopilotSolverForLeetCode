class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int maxSum = 0;
        int minSum = 0;
        int sum = 0;
        for (auto n : nums) {
            sum += n;
            maxSum = max(maxSum, sum);
            minSum = min(minSum, sum);
        }
        return maxSum - minSum;
    }
};