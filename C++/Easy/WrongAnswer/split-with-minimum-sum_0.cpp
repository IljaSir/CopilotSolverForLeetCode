class Solution {
public:
    int splitNum(int num) {
        
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    int splitWithMinSum(int num) {
        int sum = splitNum(num);
        int num1 = 0;
        int num2 = 0;
        int minSum = sum;
        int minNum1 = 0;
        int minNum2 = 0;
        for (int i = 1; i < sum; i++) {
            if (sum % i == 0) {
                num1 = i;
                num2 = sum / i;
                if (num1 + num2 < minSum) {
                    minSum = num1 + num2;
                    minNum1 = num1;
                    minNum2 = num2;
                }
            }
        }
        return minNum1 + minNum2;
    }
    int minSumOfDigits(vector<int>& nums) {
        int minSum = INT_MAX;
        for (auto num : nums) {
            int sum = splitWithMinSum(num);
            if (sum < minSum) {
                minSum = sum;
            }
        }
        return minSum % 2;
    }
};