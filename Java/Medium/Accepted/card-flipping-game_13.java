class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        int n = fronts.length;
        int[] count = new int[2001];
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                count[fronts[i]] = 1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (count[fronts[i]] == 0) {
                res = Math.min(res, fronts[i]);
            }
            if (count[backs[i]] == 0) {
                res = Math.min(res, backs[i]);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}