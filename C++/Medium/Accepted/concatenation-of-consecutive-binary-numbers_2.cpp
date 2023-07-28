class Solution {
public:
    int concatenatedBinary(int n) {
        
        int res = 0;
        int mod = 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k) {
                res = (res << 1) % mod;
                k >>= 1;
            }
            res = (res + i) % mod;
        }
        return res;
    }
};