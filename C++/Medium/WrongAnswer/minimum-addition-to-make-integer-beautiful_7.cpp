class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long sum = 0, tmp = 1;
        while (n > 0) {
            sum += (n % 10) * tmp;
            n /= 10;
            tmp *= 10;
        }
        long long ans = 0;
        while (sum > target) {
            long long x = sum / target;
            ans += x;
            sum -= x * target;
            sum += x;
        }
        return ans;
    }
};