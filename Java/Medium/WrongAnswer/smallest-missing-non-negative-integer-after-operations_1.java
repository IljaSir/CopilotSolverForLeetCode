class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (value == 0) {
            return min > 0 ? min - 1 : 0;
        }
        int[] dp = new int[max - min + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int num : nums) {
            dp[num - min] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (i - value >= 0) {
                dp[i - value] = Math.min(dp[i - value], dp[i] + 1);
            }
            if (i + value < dp.length) {
                dp[i + value] = Math.min(dp[i + value], dp[i] + 1);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                return i + min;
            }
        }
        return max + 1;
    }
}