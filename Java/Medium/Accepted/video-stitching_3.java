class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] <= i && i <= clip[1]) {
                    if (dp[clip[0]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                    }
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE ? -1 : dp[time];
    }
}