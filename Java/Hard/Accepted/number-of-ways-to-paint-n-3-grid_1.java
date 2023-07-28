class Solution {
    public int numOfWays(int n) {
        
        long a121 = 6, a123 = 6, mod = 1000000007;
        for (int i = 1; i < n; i++) {
            long b121 = (a121 * 3 + a123 * 2) % mod;
            long b123 = (a121 * 2 + a123 * 2) % mod;
            a121 = b121;
            a123 = b123;
        }
        return (int)((a121 + a123) % mod);
    }
}