class Solution {
public:
    int concatenatedBinary(int n) {
        
        long long res = 0;
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            res = (res << (32 - __builtin_clz(i))) % mod + i;
        }
        return res % mod;
    }
};