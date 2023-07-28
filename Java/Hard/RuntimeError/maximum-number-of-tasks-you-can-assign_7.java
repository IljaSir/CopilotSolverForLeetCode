class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int[] max = new int[m];
        int[] sum = new int[m];
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && tasks[j] <= workers[i]) {
                j++;
            }
            max[i] = j;
        }
        sum[m - 1] = max[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + max[i];
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int left = Math.max(0, pills - i);
            int right = Math.min(pills, m - 1 - i);
            if (left <= right) {
                res = Math.max(res, max[i] + sum[i + left] - sum[i + right + 1]);
            }
        }
        return res;
    }
}