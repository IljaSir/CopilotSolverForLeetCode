class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        
        int min = Integer.MAX_VALUE;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                int len = i - start + 1;
                if (start > 0 && dp[start - 1] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[start - 1] + len);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = Math.min(min, len);
                } else {
                    dp[i] = len;
                }
            } else {
                if (i > 0) {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}