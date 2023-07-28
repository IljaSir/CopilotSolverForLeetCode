class Solution {
public:
    int concatenatedBinary(int n) {
        
        long long ans = 0;
        int mod = 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            int t = i;
            long long base = 1;
            while (t) {
                if (t & 1) {
                    ans = (ans + base) % mod;
                }
                base = (base * 2) % mod;
                t >>= 1;
            }
        }
        return ans;
    }
};