class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] time = new int[n];
        for (int[] log : logs) {
            time[log[0]] += log[1] - (log[0] == 0 ? 0 : logs[log[0] - 1][1]);
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] > max) {
                max = time[i];
                res = i;
            }
        }
        return res;
    }
}