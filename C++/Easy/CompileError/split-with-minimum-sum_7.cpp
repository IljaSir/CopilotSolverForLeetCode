class Solution {
public:
    int splitNum(int num) {
        
        int minSum = INT_MAX;
        for (int i = 1; i <= num / 2; i++) {
            int sum = calcSum(i, num - i);
            if (sum < minSum) {
                minSum = sum;
            }
        }
        return minSum;
    }
    
    int calcSum(int num1, int num2) {
        int sum = 0;
        while (num1) {
            sum += num1 % 10;
            num1 /= 10;
        }
        while (num2) {
            sum += num2 % 10;
            num2 /= 10;
        }
        return sum;
    }
    
    int splitNum2(int num) {
        int minSum = INT_MAX;
        for (int i = 1; i <= num / 2; i++) {
            int sum = calcSum2(i, num - i);
            if (sum < minSum) {
                minSum = sum;
            }
        }
        return minSum;
    }
    
    int calcSum2(int num1, int num2) {
        int sum = 0;
        int digits[10] = {0};
        while (num1) {
            digits[num1 % 10]++;
            num1 /= 10;
        }
        while (num2) {
            digits[num2 % 10]++;
            num2 /= 10;
        }
        for (int i = 0; i < 10; i++) {
            sum += digits[i];
        }
        return sum;
    }
    
    int splitNum3(int num) {
        int minSum = INT_MAX;
        for (int i = 1; i <= num / 2; i++) {
            int sum = calcSum3(i, num - i);
            if (sum < minSum) {
                minSum = sum;
            }
        }
        return minSum;
    }
    
    int calcSum3(int num1, int num2) {
        int sum = 0;
        int digits[10] = {0};
        while (num1) {
            digits[num1 % 10]++;
            num1 /= 10;
        }
        while (num2) {
            digits[num2 % 10]++;
            num2 /= 10;
        }
        for (int i = 0; i < 10;
    }
};