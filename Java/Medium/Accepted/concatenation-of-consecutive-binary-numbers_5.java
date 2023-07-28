class Solution {
    public int concatenatedBinary(int n) {
        
        int MOD = 1_000_000_007;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ((ans << (Integer.toBinaryString(i).length())) % MOD + i) % MOD;
        }
        return (int) ans;
    }
}