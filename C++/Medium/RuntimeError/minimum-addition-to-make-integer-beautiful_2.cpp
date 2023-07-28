class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long sum = 0;
        long long m = n;
        while (m) {
            sum += m % 10;
            m /= 10;
        }
        if (sum <= target) return 0;
        long long ans = 0;
        int base = 1;
        while (sum > target) {
            int t = n % 10;
            if (t == 0) {
                n /= 10;
                base *= 10;
                continue;
            }
            ans += (10 - t) * base;
            n += (10 - t);
            sum = sum - t + (10 - t);
            base *= 10;
        }
        return ans;
    }
};