class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = ; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int res = 0, i = 0
        for (int i = 0; i < worker.length; i++) {
            while (j < n && jobs[j][0] <= worker[i]) {
                max = Math.max(max, jobs[j][1]);
                j++;
            }
            res += max;
        }
        return res;
    }
}