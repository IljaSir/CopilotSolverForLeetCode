class Solution {
    public long minimumMoney(int[][] transactions) {
        
        Arrays.sort(transactions, (a, b) -> a[0] - b[0]);
        long min = 0;
        long money = 0;
        for (int[] t : transactions) {
            long cost = t[0];
            long cashback = t[1];
            if (money < cost) {
                min += cost - money;
                money = cost;
            }
            money += cashback;
        }
        return min;
    }
}