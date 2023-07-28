class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[2][k];
        int[] crossTime = new int[k];
        int[] pickTime = new int[k];
        for (int i = 0; i < k; i++) {
            crossTime[i] = time[i][0] + time[i][2];
            pickTime[i] = time[i][1] + time[i][3];
        }
        int[] sorted = IntStream.range(0, k).boxed().sorted((i, j) -> crossTime[i] != crossTime[j] ? crossTime[i] - crossTime[j] : i - j).mapToInt(i -> i).toArray();
        int[] sorted2 = IntStream.range(0, k).boxed().sorted((i, j) -> pickTime[i] != pickTime[j] ? pickTime[i] - pickTime[j] : i - j).mapToInt(i -> i).toArray();
        for (int i = 0; i < k; i++) {
            dp[0][i] = time[sorted[i]][0] + (i > 0 ? dp[0][i - 1] : 0);
            dp[1][i] = time[sorted2[i]][1] + (i > 0 ? dp[1][i - 1] : 0);
        }
        int[] cost = new int[k];
        for (int i = 0; i < k; i++) {
            cost[sorted[i]] = Math.max(dp[0][i], dp[1][i]);
        }
        int res = 0;
        int[] dp2 = new int[k];
        for (int i = 0; i < k; i++) {
            dp2[i] = cost[i] + time[i][2] + time[i][3];
            if (i > 0) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1]);
            }
            res = Math.max(res, dp2[i] + (n - 1) * (time[i][0] + time[i][1] + time[i][2] + time[i][3]));
        }
        return res;
    }
}