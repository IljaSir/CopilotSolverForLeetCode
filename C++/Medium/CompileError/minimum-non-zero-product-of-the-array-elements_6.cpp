class Solution {
public:
    int minNonZeroProduct(int p) {
        
        long long ans = 1;
        for (int i = 0; i < p; ++i) {
            ans *= 2;
        }
        ans -= 1;
        long long half = (ans - 1) / 2;
        long long mod = 1e9 + 7;
        long long ans2 = powmod(half, ans - 2, mod);
        return (ans - 1) * ans2 % mod;
    }
};