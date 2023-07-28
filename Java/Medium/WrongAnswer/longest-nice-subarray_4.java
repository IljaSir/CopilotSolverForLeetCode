class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            bits[i] = 0;
            for (int j = 0; j < 10; j++) {
                if ((nums[i] & (1 << j)) > 0) {
                    bits[i] |= 1 << j;
                }
            }
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int x = bits[i];
            int j = i - 1;
            while (j >= 0 && (x & bits[j]) == 0) {
                x |= bits[j];
                j--;
            }
            if (x == 1023) {
                dp[i] = i - j;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}