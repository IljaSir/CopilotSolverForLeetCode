class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int m = balls.length / 2;
        long[][] dp = new long[1 << n][m + 1];
        dp[0][0] = 1;
        long total = 1;
        for (int i = 0; i < n; i++) {
            total *= C(1 + i, balls[i]);
            for (int j = (1 << i) - 1; j >= 0; j--) {
                for (int k = 0; k <= m; k++) {
                    for (int l = 1; l <= balls[i]; l++) {
                        if (k + l > m) {
                            break;
                        }
                        dp[j | (1 << i)][k + l] += dp[j][k];
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) != n / 2) {
                continue;
            }
            int j = ((1 << n) - 1) ^ i;
            int[] a = new int[n];
            int[] b = new int[n];
            for (int k = 0; k < n; k++) {
                if ((i & (1 << k)) != 0) {
                    a[k] = balls[k];
                } else {
                    b[k] = balls[k];
                }
            }
            if (check(a) && check(b)) {
                res += dp[i][m] * dp[j][m];
            }
        }
        return (double) res / total;
    }

    public boolean check(int[] a) {
        int[] cnt = new int[7];
        for (int i = 0; i < a.length; i++) {
            cnt[a[i]]++;
        }
        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                res++;
            }
        }
        return res <= a.length / 2;
    }
}