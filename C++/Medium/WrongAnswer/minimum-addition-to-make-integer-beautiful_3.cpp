class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        int sum = 0;
        for (long long i = n; i; i /= 10) {
            sum += i % 10;
        }
        if (sum <= target) {
            return 0;
        }
        long long res = 0;
        long long base = 1;
        for (long long i = n; i; i /= 10) {
            int digit = i % 10;
            int need = target - sum + digit;
            if (need > 0) {
                res += base * need;
                sum += need;
            }
            base *= 10;
        }
        return res;
    }
};