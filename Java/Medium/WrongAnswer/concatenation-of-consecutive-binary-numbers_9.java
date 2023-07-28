class Solution {
    public int concatenatedBinary(int n) {
        
        int MOD = 1000000007;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int len = 0;
            int temp = i;
            while (temp > 0) {
                temp >>= 1;
                len++;
            }
            result = ((result << len) | i) % MOD;
        }
        return result;
    }
}