class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = max(maxSum, sum);
        }
        return maxSum;
    }
};