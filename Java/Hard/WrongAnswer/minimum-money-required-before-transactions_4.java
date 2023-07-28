class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long sum = 0;
        long min = 0;
        for (int i = 0; i < transactions.length; i++) {
            sum += transactions[i][0];
            min = Math.min(min, sum);
        }
        return Math.abs(min);
    }
}