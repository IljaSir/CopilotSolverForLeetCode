class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = -1;
        }
        time[headID] = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] != -1) {
                int t = time[i] + informTime[i];
                for (int j = 0; j < n; j++) {
                    if (manager[j] == i) {
                        time[j] = Math.max(t, time[j]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(time[i], max);
        }
        return max;
    }
}