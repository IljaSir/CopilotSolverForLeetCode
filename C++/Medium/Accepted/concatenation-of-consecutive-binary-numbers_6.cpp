class Solution {
public:
    int concatenatedBinary(int n) {
        
        long long int res = 0, mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j) {
                res = (res << 1) % mod;
                j = j >> 1;
            }
            res = (res + i) % mod;
        }
        return res;
    }
};