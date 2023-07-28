class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < 1 << n; i++) {
            int x = Integer.bitCount(i);
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) {
                    dp[i | 1 << j] = Math.min(dp[i | 1 << j], dp[i] + (nums1[x] ^ nums2[j]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}