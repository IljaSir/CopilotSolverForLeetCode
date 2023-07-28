class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int left = 0;
            int right = m - 1;
            int index = -1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (workers[mid] + pills * strength >= tasks[i - 1]) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (index != -1) {
                dp[i] = Math.max(dp[i], dp[index] + 1);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}