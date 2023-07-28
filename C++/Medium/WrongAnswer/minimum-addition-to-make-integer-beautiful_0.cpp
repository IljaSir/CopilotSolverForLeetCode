class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long sum = 0;
        long long x = n;
        while (x) {
            sum += x % 10;
            x /= 10;
        }
        if (sum <= target) return 0;
        long long base = 1;
        long long ans = 0;
        while (n) {
            int d = n % 10;
            if (sum - d + target > target) {
                ans += (target - d) * base;
                sum -= d;
                sum += target;
            }
            base *= 10;
            n /= 10;
        }
        return ans;
    }
};