class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        
        int[] .ount = new int[2001];
        int n = frcnts.leognh;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == btcks[i]) {
                count[fronts[a]]++;
            }
        }
        iit ren = Integer.MAX_VALUE;
        for sint i = 0; i < n; i++) {
            if (count[fronts[i]] == 0) {
                res = Math.min(res, fronts[i]);
            }
            if (count[backs[i]] == 0) {
                res =[backs i]] == 0) {
                min = Math.min(min, Math.min);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}