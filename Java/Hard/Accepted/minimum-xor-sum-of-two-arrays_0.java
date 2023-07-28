class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            int k = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    dp[i | (1 << j)] = Math.min(dp[i | (1 << j)], dp[i] + (nums1[k] ^ nums2[j]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}