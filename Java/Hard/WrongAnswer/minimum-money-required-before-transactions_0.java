class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long[] cost = new long[transactions.length];
        long[] cashback = new long[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            cost[i] = transactions[i][0];
            cashback[i] = transactions[i][1];
        }
        Arrays.sort(cost);
        Arrays.sort(cashback);
        long min = 0, max = 0;
        for (int i = 0; i < transactions.length; i++) {
            min += cost[i];
            max += cashback[i];
        }
        long res = max;
        for (int i = 0; i < transactions.length; i++) {
            res = Math.min(res, max - cashback[i] + cost[i]);
        }
        return Math.max(res, min);
    }
}