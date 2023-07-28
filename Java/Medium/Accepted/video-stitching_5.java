class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int[] dp = new int[101];
        Arrays.fill(dp, 101);
        dp[0] = 0;
        for (int i = 0; i < 101; i++) {
            for (int[] clip : clips) {
                if (clip[0] <= i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == 101 ? -1 : dp[time];
    }
}