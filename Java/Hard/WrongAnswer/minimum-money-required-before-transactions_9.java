class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long res = 0;
        long total = 0;
        for (int[] t : transactions) {
            total += t[0] - t[1];
            res = Math.max(res, total);
        }
        return res;
    }
}