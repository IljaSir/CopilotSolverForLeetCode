class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] tasks = new int[n];
        int max = 0;
        int res = 0;
        for (int i = 0; i < logs.length; i++) {
            tasks[logs[i][0]] += (i == 0 ? logs[i][1] : logs[i][1] - logs[i - 1][1]);
            if (tasks[logs[i][0]] > max) {
                max = tasks[logs[i][0]];
                res = logs[i][0];
            }
        }
        return res;
    }
}