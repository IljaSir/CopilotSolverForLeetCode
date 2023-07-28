class Solution {
    public int concatenatedBinary(int n) {
        
        int mod = 1000000007;
        long res = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                len++;
            }
            res = ((res << len) + i) % mod;
        }
        return (int) res;
    }
}