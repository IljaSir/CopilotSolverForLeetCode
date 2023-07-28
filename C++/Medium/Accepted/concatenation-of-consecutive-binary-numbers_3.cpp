class Solution {
public:
    int concatenatedBinary(int n) {
        
        int mod = 1000000007;
        long long res = 0;
        for (int i = 1; i <= n; i++) {
            int bits = log2(i) + 1;
            res = ((res << bits) | i) % mod;
        }
        return res;
    }
};