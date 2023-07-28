class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long sum = 0;
        long long x = n;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        if (sum > target) {
            long long base = 1;
            long long add = 0;
            while (sum > target) {
                long long d = n / base % 10;
                if (d < 9) {
                    long long a = min(9 - d, sum - target);
                    n += a * base;
                    sum -= a;
                }
                base *= 10;
            }
        }
        return n - sum;
    }
};