class Solution {
public:
    int splitNum(int num) {
        
        int sum = 0;
        while (num) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    int split(int num, int idx, int sum, int &minSum) {
        if (idx == 0) {
            int num2 = sum - num;
            minSum = min(minSum, num + num2);
            return 0;
        }
        int n = num % 10;
        num /= 10;
        int res = 0;
        for (int i = 0; i <= n; ++i) {
            res += split(num, idx - 1, sum - i, minSum);
        }
        return res;
    }
    int splitWithMinimumSum(int num) {
        int minSum = INT_MAX;
        int idx = 0;
        int num1 = num;
        while (num1) {
            num1 /= 10;
            ++idx;
        }
        split(num, idx, splitNum(num), minSum);
        return minSum;
    }
};