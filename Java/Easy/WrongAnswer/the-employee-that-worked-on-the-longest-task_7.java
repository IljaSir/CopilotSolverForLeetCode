class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] times = new int[n];
        for (int[] log : logs) {
            times[log[0]] += log[1];
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] > max) {
                max = times[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}