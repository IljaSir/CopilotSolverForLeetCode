class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                int start = clip[0];
                int end = clip[1];
                if (start < i && i <= end) {
                    if (dp[start] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[start] + 1);
                    }
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE ? -1 : dp[time];
    }
}