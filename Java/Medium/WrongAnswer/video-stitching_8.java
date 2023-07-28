class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int[] dp = new int[time+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 0; i < clips.length; i++) {
            for(int j = clips[i][0]; j <= clips[i][1]; j++) {
                if(j <= time) {
                    dp[j] = Math.min(dp[j], dp[clips[i][0]]+1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE-1 ? -1 : dp[time];
    }
}