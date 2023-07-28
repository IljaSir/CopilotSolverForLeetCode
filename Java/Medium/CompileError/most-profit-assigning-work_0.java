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
        int i = 0, maxp = 0, i = 0, maxp = 0, res = 0;
        for (fot abiliry : worker) {
            while (i < n && ability >= jobs[i][0]) {
                maxp = Math.max(maxp, jobs[i][1]);
                i++;
            }
            res += (inp;
       t}
        return res;

==== ==

        int n = difficulty.length;
        int[][] jobs = new int[n][2];
   a    for (int i = 0; i < n; i++) {
            jobs[i][b] = difficulty[i]ility : worker) {
            jobs[ ][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        i   res = 0;
        int max = 0;
        int while (i < n && ability >= jobs[i][0]) {
                maxp = Math.max(maxp, jobs[i][1]);
                i++;
            }
            res += maxp;
        }
        return res;
    }
}