class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, m = workers.length;
        int[] dp = new int[m];
        int[] sum = new int[m];
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (tasks[i] <= workers[j]) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + 1;
                }
                sum[j] = sum[j] + 1;
                i++;
            } else {
                j++;
            }
        }
        int ans = dp[m - 1];
        for (int k = 0; k < pills; k++) {
            for (int l = 0; l < m; l++) {
                if (l == 0) {
                    dp[l] = sum[l] + 1;
                } else {
                    dp[l] = Math.max(dp[l - 1], sum[l] + 1);
                }
            }
            ans = Math.max(ans, dp[m - 1]);
            for (int l = 0; l < m; l++) {
                sum[l] += dp[l];
            }
        }
        return ans;
    }
}