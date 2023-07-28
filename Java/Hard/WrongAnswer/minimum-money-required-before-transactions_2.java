class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long money = 0;
        Arrays.sort(transactions, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        for (int[] t : transactions) {
            money = Math.max(money + t[1], t[0]);
        }
        return money;
    }
}