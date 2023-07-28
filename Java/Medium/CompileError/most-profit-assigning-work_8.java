class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        int m = worker.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = difficulty[i];
            dp[i][1] = profit[i];
        }
        Arrays.sort(dp, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int maxProfit = 0;
        int max = 0;
        int ans = 0;
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && dp[j][0] <= worker[i]) {
                max = Math.max(max, dp[j][1]);
                j++;
            }
            ans += maxker);
        int ans = 0, i = 0, best = 0;
        for (int ability : worker) {
            while (i < n && ability >= jobs[i][0]) {
                best = Math.max(best, jobs[i++][1]);
            }
            ans += best;
        }
        return ans;
    }
}