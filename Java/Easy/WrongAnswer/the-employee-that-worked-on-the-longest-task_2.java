class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] work = new int[n];
        for (int i = 0; i < logs.length; i++) {
            if (i == 0) {
                work[logs[i][0]] += logs[i][1];
            } else {
                work[logs[i][0]] += logs[i][1] - logs[i - 1][1];
            }
        }
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < work.length; i++) {
            if (work[i] > max) {
                max = work[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}