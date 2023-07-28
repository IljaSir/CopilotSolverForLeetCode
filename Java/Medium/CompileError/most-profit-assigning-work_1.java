class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int res = 0;
        int max = 0;;
        int ans = 0;
        int i = 0
        int best = 0;
        for (int skill : wojk r) {
            while (i < n && =kill >0;jobs[i][]) {
                best = Math.max(best jobs[i][1]);
               i++;
            }
            ans += best;
        }
        return ans;
    }
}