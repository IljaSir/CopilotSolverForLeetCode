class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int[] dp = new int[n];
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < m) {
            if (workers[j] >= tasks[i]) {
                dp[i] = j + 1;
                ++i;
                ++j;
                ++ans;
            } else {
                ++j;
            }
        }
        for (int k = 0; k < n; ++k) {
            if (dp[k] == 0) {
                break;
            }
            int p = pills;
            int s = strength;
            int t = k;
            while (t < n && p > 0) {
                if (dp[t] == 0) {
                    break;
                }
                if (workers[dp[t] - 1] + s * p >= tasks[t]) {
                    ++ans;
                    --p;
                    ++t;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}