class Solution {
public:
    int countGoodNumbers(long long n) {
        
        long long ans = 1;
        long long mod = 1e9 + 7;
        long long a = n / 2;
        long long b = n - a;
        long long a1 = 20;
        long long b1 = 5;
        while (a) {
            if (a & 1) {
                ans *= a1;
                ans %= mod;
            }
            a1 *= a1;
            a1 %= mod;
            a >>= 1;
        }
        while (b) {
            if (b & 1) {
                ans *= b1;
                ans %= mod;
            }
            b1 *= b1;
            b1 %= mod;
            b >>= 1;
        }
        return ans;
    }
};