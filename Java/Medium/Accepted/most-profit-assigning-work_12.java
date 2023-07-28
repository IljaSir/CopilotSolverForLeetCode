class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new int[] {difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        int max = 0, result = 0, i = 0;
        for (int ability : worker) {
            while (i < difficulty.length && ability >= jobs[i][0]) {
                max = Math.max(max, jobs[i][1]);
                i++;
            }
            result += max;
        }
        return result;
    }
}