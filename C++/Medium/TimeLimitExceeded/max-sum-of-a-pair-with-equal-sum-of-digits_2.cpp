class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int maxsum = -1;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int sum1 = 0;
                int sum2 = 0;
                int num1 = nums[i];
                int num2 = nums[j];
                while (num1 > 0) {
                    sum1 += num1 % 10;
                    num1 /= 10;
                }
                while (num2 > 0) {
                    sum2 += num2 % 10;
                    num2 /= 10;
                }
                if (sum1 == sum2) {
                    maxsum = max(maxsum, nums[i] + nums[j]);
                }
            }
        }
        return maxsum;
    }
};