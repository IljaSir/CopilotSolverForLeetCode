class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int ans = 0, i = 0, best = 0;
        for (int skill : worker) {
            while (i < n && skill >= jobs[i][0]) {
                best = Math.max(best, jobs[i][1]);
                ++i;
            }
            ans += best;
        }
        return ans;
    }
}