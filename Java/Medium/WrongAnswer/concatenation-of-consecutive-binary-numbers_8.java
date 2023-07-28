class Solution {
    public int concatenatedBinary(int n) {
        
        int len = 1;
        int res = 0;
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                len++;
            }
            res = ((res << len) % mod + i) % mod;
        }
        return res;
    }
}