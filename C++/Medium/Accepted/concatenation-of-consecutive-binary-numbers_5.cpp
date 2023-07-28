class Solution {
public:
    int concatenatedBinary(int n) {
        
        int MOD = 1000000007;
        long long ans = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            int bit = 0;
            while (x) {
                x >>= 1;
                bit++;
            }
            ans = ((ans << bit) + i) % MOD;
        }
        return ans;
    }
};