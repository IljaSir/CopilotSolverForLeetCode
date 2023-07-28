class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int maxSum = -1;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (sumOfDigits(nums[i]) == sumOfDigits(nums[j])) {
                    sum = nums[i] + nums[j];
                    if (sum > maxSum)
                        maxSum = sum;
                }
            }
        }
        return maxSum;
    }
    
    int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
};