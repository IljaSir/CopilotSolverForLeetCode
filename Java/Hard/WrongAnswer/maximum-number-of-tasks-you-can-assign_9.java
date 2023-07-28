class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        int n = tasks.length;
        int m = workers.length;
        int[] availableWorkers = new int[m];
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < m && workers[j] < tasks[0]) {
                j++;
            }
            availableWorkers[i] = j;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= pills && i - k >= 0; k++) {
                int need = tasks[i] - (k * strength);
                int pos = binarySearch(availableWorkers, need);
                dp[i + 1] = Math.max(dp[i + 1], dp[i - k + 1] + pos);
            }
        }
        return dp[n];
    }

    private int binarySearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] <= x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}