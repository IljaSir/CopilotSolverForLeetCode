class Solution {
public:
    long long makeIntegerBeautiful(long long n, int target) {
        
        long long res = 0;
        long long m = 1;
        while (n) {
            int d = n % 10;
            n /= 10;
            if (d < target) {
                res += (target - d) * m;
            }
            m *= 10;
        }
        return res;
    }
};