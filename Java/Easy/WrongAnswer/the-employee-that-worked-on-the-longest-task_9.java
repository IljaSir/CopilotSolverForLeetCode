class Solution {
    public int hardestWorker(int n, int[][] logs) {
        
        int[] duration = new int[n];
        int max = 0;
        int maxId = 0;
        for(int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int time = logs[i][1];
            if(i == 0) {
                duration[id] = logs[i][1];
            } else {
                duration[id] = logs[i][1] - logs[i - 1][1];
            }
            if(duration[id] > max) {
                max = duration[id];
                maxId = id;
            }
        }
        return maxId;
    }
}