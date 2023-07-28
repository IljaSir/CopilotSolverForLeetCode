class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        int m = rides.length;
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        long[] f = new long[m + 1];
        int j = 0;
        for (int i = 1; i <= m; i++) {
            f[i] = Math.max(f[i - 1], f[i]);
            while (j < m && rides[j][0] <= rides[i - 1][1]) {
                j++;
            }
            f[j] = Math.max(f[j], f[i - 1] + (long)(rides[i - 1][1] - rides[i - 1][0]) + rides[i - 1][2]);
        }
        return f[m];
    }
}