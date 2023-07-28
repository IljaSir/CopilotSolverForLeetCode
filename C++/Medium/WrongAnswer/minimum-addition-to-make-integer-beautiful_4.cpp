class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long sum = 0;
        long long tmp = n;
        while (tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (sum <= target) return 0;
        long long ans = 0;
        long long base = 1;
        while (n != 0) {
            int d = n % 10;
            if (d == 0) {
                base *= 10;
                n /= 10;
                continue;
            }
            sum -= d;
            if (sum + target >= d) {
                ans += (target - d) * base;
                sum += target;
            } else {
                ans += (10 - d) * base;
                sum += 10;
            }
            base *= 10;
            n /= 10;
        }
        return ans;
    }
};