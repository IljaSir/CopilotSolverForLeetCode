class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int[] workers = new int[k];
        return dfs(jobs, workers, 0);
    }
    
    private int dfs(int[] jobs, int[] workers, int i) {
        if (i == jobs.length) {
            return Arrays.stream(workers).max().getAsInt();
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < workers.length; j++) {
            workers[j] += jobs[i];
            min = Math.min(min, dfs(jobs, workers, i + 1));
            workers[j] -= jobs[i];
            if (workers[j] == 0) {
                break;
            }
        }
        return min;
    }
}