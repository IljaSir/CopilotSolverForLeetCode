class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int[] dp = new int[time];
        Arrays.fill(dp, time+1);
        dp[0] = 0;
        for (int i = 0; i < time; i++) {
            for (int[] clip : clips) {
                if (clip[0] <= i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time-1] == time+1 ? -1 : dp[time-1];
    }
}