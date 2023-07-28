class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        int n = tasks.length;
        int m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int[] pillsToWorker = new int[m];
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n && j < m) {
            if (workers[j] >= tasks[i]) {
                count++;
                i++;
            }
            j++;
        }
        int ans = count;
        for (int k = 0; k < m; k++) {
            pillsToWorker[k] = Math.min(pills, (int) ((long) (strength - workers[k]) / strength));
            if (pillsToWorker[k] == 0) {
                continue;
            }
            i = 0;
            j = 0;
            count = 0;
            while (i < n && j < m) {
                if (workers[j] + pillsToWorker[k] * strength >= tasks[i]) {
                    count++;
                    i++;
                }
                j++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}