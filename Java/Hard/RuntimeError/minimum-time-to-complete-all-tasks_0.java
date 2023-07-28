class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int max = 0;
        for (int[] task : tasks) {
            max = Math.max(max, task[1]);
        }
        int[] dp = new int[max + 1];
        for (int[] task : tasks) {
            dp[task[0]] += task[2];
            dp[task[1] + 1] -= task[2];
        }
        int res = 0;
        int count = 0;
        for (int i = 0; i <= max; i++) {
            count += dp[i];
            res = Math.max(res, count);
        }
        return res;
    }
}