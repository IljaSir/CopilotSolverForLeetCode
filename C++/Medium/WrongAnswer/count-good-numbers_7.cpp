class Solution {
public:
    int countGoodNumbers(long long n) {
        
        long long ans = 1;
        long long mod = 1e9 + 7;
        if (n % 2 == 1) {
            ans = ans * 5;
            ans = ans % mod;
        }
        long long tmp = 20;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * tmp;
                ans = ans % mod;
            }
            tmp = tmp * tmp;
            tmp = tmp % mod;
            n = n / 2;
        }
        return ans;
    }
};