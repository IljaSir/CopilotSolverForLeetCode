class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] workTime = new int[n];
        for(int[] log : logs) {
            workTime[log[0]] += log[1] - (log[0] == 0 ? 0 : logs[log[0] - 1][1]);
        }
        int max = 0;
        int id = 0;
        for(int i = 0; i < n; i++) {
            if(workTime[i] > max) {
                max = workTime[i];
                id = i;
            }
        }
        return id;
    }
}