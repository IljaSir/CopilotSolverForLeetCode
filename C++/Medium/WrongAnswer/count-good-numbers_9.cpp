class Solution {
public:
    int countGoodNumbers(long long n) {
        
        long long ans = 1;
        long long MOD = 1000000007;
        long long even = n/2;
        long long odd = n-even;
        ans = (ans * powmod(5,even,MOD)) % MOD;
        ans = (ans * powmod(4,odd,MOD)) % MOD;
        return ans;
    }
    long long powmod(long long x, long long y, long long MOD) {
        long long ans = 1;
        while(y) {
            if(y&1) ans = (ans * x) % MOD;
            x = (x * x) % MOD;
            y = y >> 1;
        }
        return ans;
    }
};