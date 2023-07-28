class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i;
            while (manager[j] != -1) {
                time[i] += informTime[manager[j]];
                j = manager[j];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, time[i]);
        }
        return max;
    }
}