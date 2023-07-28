class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long sum = 0;
        long long m = n;
        while(m > 0) {
            sum += m % 10;
            m /= 10;
        }
        if(sum <= target) return 0;
        long long res = 0;
        long long p = 1;
        while(sum > target) {
            long long x = n % 10;
            res += (10 - x) * p;
            n /= 10;
            sum -= x;
            p *= 10;
        }
        return res;
    }
};