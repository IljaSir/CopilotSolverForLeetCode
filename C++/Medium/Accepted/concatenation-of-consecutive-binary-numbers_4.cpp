class Solution {
public:
    int concatenatedBinary(int n) {
        
        int mod = 1000000007;
        long long ans = 0;
        for (int i = 1; i <= n; i++) {
            int len = 0, t = i;
            while (t) {
                t >>= 1;
                len++;
            }
            ans = ((ans << len) + i) % mod;
        }
        return ans;
    }
};