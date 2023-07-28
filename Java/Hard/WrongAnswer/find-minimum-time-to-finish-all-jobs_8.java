class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[] maxTime = new int[1];
        maxTime[0] = Integer.MAX_VALUE;
        dfs(jobs, n, k, 0, 0, 0, maxTime, new boolean[n]);
        return maxTime[0];
    }

    private void dfs(int[] jobs, int n, int k, int start, int curTime, int maxTime, int[] minTime, boolean[] used) {
        if (maxTime >= minTime[0]) {
            return;
        }

        if (start == n) {
            minTime[0] = Math.min(minTime[0], maxTime);
            return;
        }

        if (k == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(jobs, n, k - 1, start + 1, 0, Math.max(maxTime, curTime + jobs[i]), minTime, used);
                used[i] = false;
                if (curTime == 0) {
                    break;
                }
            }
        }
    }
}