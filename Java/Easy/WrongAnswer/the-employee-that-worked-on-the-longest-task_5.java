class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] times = new int[n];
        int maxTime = 0;
        int maxId = 0;
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int leaveTime = logs[i][1];
            int startTime = i == 0 ? 0 : logs[i - 1][1];
            times[id] += leaveTime - startTime;
            if (times[id] > maxTime) {
                maxTime = times[id];
                maxId = id;
            }
        }
        return maxId;
    }
}