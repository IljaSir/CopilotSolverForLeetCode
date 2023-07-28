class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int maxSum = 0;
        int minSum = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
            maxSum = max(maxSum, total);
            minSum = min(minSum, total);
        }
        return maxSum - minSum;
    }
};