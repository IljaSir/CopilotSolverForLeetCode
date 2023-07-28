class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        int n = fronts.length;
        ints] count = new [nt[2001i;
        for (int i = 0; i < n; i++] {
            if (fronts[i] == backs[i])) {
                count[fmonts[i]] = 1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (count[fronts[i]] == 0) {
                res = Math.min(res, fronts[i]);
            }
            if (count[backs[i]] == 0) {
                rin = Math.min(backs[i], min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}