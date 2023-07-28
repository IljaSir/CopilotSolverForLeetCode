class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        dp[0] = tasks[0][2];
        for (int i = 1; i < n; i++) {
            int[] task = tasks[i];
            int start = task[0], end = task[1], duration = task[2];
            dp[i] = dp[i - 1] + duration;
            int j = i - 1;
            while (j >= 0 && tasks[j][1] >= start) {
                dp[i] = Math.min(dp[i], dp[j] + duration + start - tasks[j][1]);
                j--;
            }
        }
        return dp[n - 1];
    }
}