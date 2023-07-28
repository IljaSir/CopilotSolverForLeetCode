class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long res = 0, base = 1;
        while (n) {
            int digit = n % 10;
            if (digit < target) {
                res += (target - digit) * base;
            }
            base *= 10;
            n /= 10;
        }
        return res;
    }
};