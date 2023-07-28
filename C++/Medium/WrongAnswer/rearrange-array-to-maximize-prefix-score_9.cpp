class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int size = nums.size();
        int sum = 0;
        int maxSum = 0;
        int maxNum = INT_MIN;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            maxNum = max(maxNum, nums[i]);
            maxSum = max(maxSum, sum);
            nums[i] = maxNum;
        }
        int score = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] > 0) {
                score++;
            }
        }
        return score;
    }
};