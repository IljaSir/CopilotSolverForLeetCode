class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[] workers = new int[k];
        int[] jobsTaken = new int[n];
        return dfs(jobs, workers, jobsTaken, 0);
    }
    
    private int dfs(int[] jobs, int[] workers, int[] jobsTaken, int jobIndex) {
        if (jobIndex == jobs.length) {
            int max = 0;
            for (int worker : workers) {
                max = Math.max(max, worker);
            }
            return max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < workers.length; i++) {
            if (jobsTaken[jobIndex] == 0) {
                jobsTaken[jobIndex] = 1;
                workers[i] += jobs[jobIndex];
                min = Math.min(min, dfs(jobs, workers, jobsTaken, jobIndex + 1));
                workers[i] -= jobs[jobIndex];
                jobsTaken[jobIndex] = 0;
            }
        }
        return min;
    }
}