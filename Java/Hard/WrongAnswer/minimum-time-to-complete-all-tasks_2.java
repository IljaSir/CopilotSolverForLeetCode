class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[] dp = new int[n];
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];
            int duration = tasks[i][2];
            int idx = binarySearch(tasks, start);
            dp[i] = duration + (idx == -1 ? 0 : dp[idx]);
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
        }
        return dp[n - 1];
    }
    
    private int binarySearch(int[][] tasks, int start) {
        int l = 0;
        int r = tasks.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (tasks[m][1] < start) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l == tasks.length ? -1 : l;
    }
}