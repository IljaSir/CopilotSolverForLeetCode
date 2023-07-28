class Solution {
public:
    int concatenatedBinary(int n) {
        
        int ans = 0;
        int mod = 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            ans = ((ans << (32 - __builtin_clz(i))) % mod + i) % mod;
        }
        return ans;
    }
};