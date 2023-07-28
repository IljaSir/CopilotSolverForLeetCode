class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int[] dp = new int[time + 1];
        Arrays.fill(dp, 101);
        dp[0] = 0;
        for (int i = 0; i < time; i++) {
            for (int[] c : clips) {
                if (c[0] <= i && c[1] >= i + 1) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[c[0]] + 1);
                }
            }
        }
        return dp[time] == 101 ? -1 : dp[time];
    }
}