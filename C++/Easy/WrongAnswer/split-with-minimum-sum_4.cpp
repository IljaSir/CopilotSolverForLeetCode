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
    int minSum(int num) {
        int n = num;
        int sum = splitNum(num);
        int sum1 = 0;
        int sum2 = 0;
        while (n) {
            int d = n % 10;
            n /= 10;
            if (d == 0) continue;
            if (sum1 == 0) {
                sum1 = d;
            } else {
                if (sum1 * 10 + d <= sum2) {
                    sum1 = sum1 * 10 + d;
                } else {
                    sum2 = sum2 * 10 + d;
                }
            }
        }
        return sum1 + sum2;
    }
};