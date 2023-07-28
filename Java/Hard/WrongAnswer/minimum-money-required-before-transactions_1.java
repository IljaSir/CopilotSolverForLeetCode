class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long[] diff = new long[transactions.length];
        long sum = 0;
        for (int i = 0; i < transactions.length; i++) {
            diff[i] = transactions[i][0] - transactions[i][1];
            sum += transactions[i][0];
        }
        Arrays.sort(diff);
        long min = 0;
        for (int i = 0; i < diff.length; i++) {
            if (sum < min) {
                return min;
            }
            min += diff[i];
            sum -= diff[i];
        }
        return min;
    }
}