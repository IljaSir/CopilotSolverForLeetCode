class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workers[j - 1] >= tasks[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        int ans = dp[n][m];
        for (int i = 1; i <= m; i++) {
            int left = pills;
            int j = i;
            int cnt = 0;
            while (j <= m && left > 0 && workers[j - 1] + left * strength >= tasks[n - 1]) {
                cnt++;
                left--;
                j++;
            }
            ans = Math.max(ans, dp[n][i - 1] + cnt);
        }
        return ans;
    }
}