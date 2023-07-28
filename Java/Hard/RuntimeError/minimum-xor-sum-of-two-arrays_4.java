class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int xor = 0;
            int cnt = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= nums1[cnt] ^ nums2[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    dp[mask | (1 << i)] = Math.min(dp[mask | (1 << i)], dp[mask] + xor);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}