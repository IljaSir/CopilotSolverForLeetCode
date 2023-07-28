class Solution {
    public int concatenatedBinary(int n) {
        
        int MOD = 1_000_000_007;
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            result = ((result << Integer.toBinaryString(i).length()) + i) % MOD;
        }
        return result;
    }
}