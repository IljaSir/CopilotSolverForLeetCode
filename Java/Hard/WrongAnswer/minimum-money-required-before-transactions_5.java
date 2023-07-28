class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long ans = 0;
        int n = transactions.length;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = transactions[i][0] - transactions[i][1];
        }
        Arrays.sort(a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + a[i] < 0) {
                ans += -sum - a[i];
                sum = 0;
            } else {
                sum += a[i];
            }
        }
        return ans;
    }
}