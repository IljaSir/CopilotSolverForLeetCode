class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long min = 0;
        long sum = 0;
        for (int[] t : transactions) {
            sum += t[0];
            min = Math.min(min, sum - t[1]);
        }
        return Math.max(0, -min);
    }
}