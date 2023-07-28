class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = dp[mask];
            int i = Integer.bitCount(mask);
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    dp[mask | (1 << j)] = Math.min(dp[mask | (1 << j)], sum + (nums1[i] ^ nums2[j]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}