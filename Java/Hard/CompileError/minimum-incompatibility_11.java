class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int m = n / k;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
            b[i] = nums[i];
            c[i] = nums[i];
            d[i] = nums[i];
            e[i] = nums[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        Arrays.sort(d);
        Arrays.sort(e);
        int[][] f = new int[n][n];
        int[][] g = new int[n][n];
        int[][] h = new int[n][n];
        int[][] i = new int[n][n];
        int[][] j = new int[n][n];
        for (int l = 0; l < n; l++) {
            f[l][l] = a[l];
            g[l][l] = b[l];
            h[l][l] = c[l];
            i[l][l] = d[l];
            j[l][l] = e[l];
        }
        for (int l = 1; l < n; l++) {
            for (int o = 0; o < n - l; o++) {
                f[o][o + l] = f[o][o + l - 1] + a[o + l];
                g[o][o + l] = g[o][o + l - 1] + b[o + l];
                h[o][o + l] = h[o][o + l - 1] + c[o + l];
                i[o][o + l] = i[o][o + l - 1] + d[o + l];
                j[o][o + l] = j[o][o + l - 1] + e[o + l];
            }
        }
        int[][] dp = new int[k][1 << n];
        for (int l = 0; l < k; l++) {
            Arrays.fill(dp[l], Integer.MAX_VALUE);
        }
        for (int l = 0; l < (1 << n); l++) {
            if (Integer.bitCount(l) == m
    }
}