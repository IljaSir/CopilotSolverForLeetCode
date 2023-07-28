class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        long sum1 = 0;
        long sum2 = 0;
        int n = basket1.length;
        for (int i = 0; i < n; i++) {
            sum1 += basket1[i];
            sum2 += basket2[i];
        }
        if (sum1 < sum2) {
            int[] tmp = basket1;
            basket1 = basket2;
            basket2 = tmp;
            long tmp2 = sum1;
            sum1 = sum2;
            sum2 = tmp2;
        }
        long ans = Long.MAX_VALUE;
        int[] cnt = new int[100001];
        for (int i = 0; i < n; i++) {
            cnt[basket1[i]]++;
            cnt[basket2[i]]++;
        }
        int[] a = new int[100001];
        int[] b = new int[100001];
        int[] c = new int[100001];
        int[] d = new int[100001];
        int[] e = new int[100001];
        int[] f = new int[100001];
        int[] g = new int[100001];
        int[] h = new int[100001];
        int[] i = new int[100001];
        int[] j = new int[100001];
        for (int k = 0; k < n; k++) {
            a[basket1[k]]++;
            b[basket2[k]]++;
        }
        for (int k = 0; k < n; k++) {
            c[basket1[k]]++;
            d[basket2[k]]++;
            if (a[basket1[k]] + b[basket2[k]] == cnt[basket1[k]]) {
                e[basket1[k]]++;
                f[basket2[k]]++;
            }
        }
        for (int k = 0; k < n; k++) {
            g[basket1[k]]++;
            h[basket2[k]]++;
            if (c[basket1[k]] + d[basket2[k]] == cnt[basket1[k]]) {
                i[basket1[k]]++;
                j[basket2[k]]++;
            }
        }
        for (int k = 1; k <= 100000; k++) {
            if (cnt[k] % 2 == 0) {
                ans = Math.min
    }
}