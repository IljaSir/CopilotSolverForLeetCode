class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int max = 0;
        for (int[] task : tasks) {
            max = Math.max(max, task[1]);
        }
        int[] dp = new int[max + 2];
        for (int i = 1; i <= max; i++) {
            dp[i] = dp[i - 1];
            for (int[] task : tasks) {
                if (task[0] <= i && i <= task[1]) {
                    dp[i] = Math.max(dp[i], dp[task[0] - 1] + task[2]);
                }
            }
        }
        return dp[max];
    }
}