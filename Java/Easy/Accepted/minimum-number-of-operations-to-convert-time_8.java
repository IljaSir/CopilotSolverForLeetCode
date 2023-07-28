class Solution {
    public int convertTime(String current, String correct) {
        
        int[] times = new int[2];
        int[] timee = new int[2];
        String[] time = current.split(":");
        times[0] = Integer.parseInt(time[0]);
        times[1] = Integer.parseInt(time[1]);
        time = correct.split(":");
        timee[0] = Integer.parseInt(time[0]);
        timee[1] = Integer.parseInt(time[1]);
        int start = times[0] * 60 + times[1];
        int end = timee[0] * 60 + timee[1];
        int[] dp = new int[end - start + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                if (i + 1 < dp.length) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
                }
                if (i + 5 < dp.length) {
                    dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
                }
                if (i + 15 < dp.length) {
                    dp[i + 15] = Math.min(dp[i + 15], dp[i] + 1);
                }
                if (i + 60 < dp.length) {
                    dp[i + 60] = Math.min(dp[i + 60], dp[i] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}