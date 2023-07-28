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
    int splitNum2(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        return sum1 + sum2;
    }
    int splitNum3(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        int sum3 = splitNum(num1 + num2);
        return (sum1 + sum2) - sum3;
    }
    int splitNum4(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        int sum3 = splitNum(num1 + num2);
        return (sum1 + sum2) - sum3;
    }
    int splitNum5(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        int sum3 = splitNum(num1 + num2);
        return (sum1 + sum2) - sum3;
    }
    int splitNum6(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        int sum3 = splitNum(num1 + num2);
        return (sum1 + sum2) - sum3;
    }
    int splitNum7(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        int sum3 = splitNum(num1 + num2);
        return (sum1 + sum2) - sum3;
    }
    int splitNum8(int num1, int num2) {
        int sum1 = splitNum(num1);
        int sum2 = splitNum(num2);
        int sum3 = splitNum(num1 + num2);
        return (sum1 + sum2) - sum3;
    }
};