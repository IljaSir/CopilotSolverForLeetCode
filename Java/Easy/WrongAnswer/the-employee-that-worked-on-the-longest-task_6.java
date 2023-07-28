class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] times = new int[n];
        int max = 0;
        int maxId = 0;
        for (int[] log : logs) {
            times[log[0]] += log[1] - (log[0] == 0 ? 0 : logs[log[0] - 1][1]);
            if (times[log[0]] > max) {
                max = times[log[0]];
                maxId = log[0];
            }
        }
        return maxId;
    }
}