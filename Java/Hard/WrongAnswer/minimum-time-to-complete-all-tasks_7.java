class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < (1 << n); i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    min = Math.min(min, tasks[j][0]);
                    max = Math.max(max, tasks[j][1]);
                }
            }
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (tasks[j][0] <= min && max <= tasks[j][1]) {
                        int prev = i - (1 << j);
                        dp[i] = Math.min(dp[i], dp[prev] + tasks[j][2]);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}