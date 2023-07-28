class Solution {
    public int concatenatedBinary(int n) {
        
        int MOD = 1000000007;
        long result = 0;
        int bits = 0;
        for (int i = 1; i <= n; ++i) {
            if ((i & (i - 1)) == 0) {
                bits++;
            }
            result = ((result << bits) % MOD + i) % MOD;
        }
        return (int) result;
    }
}