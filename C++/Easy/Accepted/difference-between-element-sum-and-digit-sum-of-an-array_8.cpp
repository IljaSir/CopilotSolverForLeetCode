class Solution {
public:
    int differenceOfSum(vector<int>& nums) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum1 += nums[i];
            sum2 += getSumOfDigits(nums[i]);
        }
        return abs(sum1 - sum2);
    }
    
    int getSumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
};