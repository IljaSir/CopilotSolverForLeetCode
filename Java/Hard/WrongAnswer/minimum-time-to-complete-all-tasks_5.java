class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[] dp = new int[2001];
        for (int i = 0; i < n; i++) {
            for (int j = tasks[i][0]; j <= tasks[i][1]; j++) {
                dp[j] += tasks[i][2];
            }
        }
        int res = 0;
        for (int i = 0; i < 2001; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}