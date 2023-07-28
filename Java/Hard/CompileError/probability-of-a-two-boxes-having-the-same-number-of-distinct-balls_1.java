class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += balls[i];
        }
        int[] a = new int[n];
        int[] b = new int[n];
        double[] dp = new double[1 << n];
        dp[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += balls[j];
                }
            }
            if (sum == total / 2) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) == 0) {
                        a[j] = balls[j] - Integer.bitCount(i & ((1 << j) - 1));
                    }
                }
            }
            if (sum == total) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) == 0) {
                        b[j] = balls[j] - Integer.bitCount(i & ((1 << j) - 1));
                    }
                }
            }
        }
        int[] count = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += a[j];
                }
            }
            count[i] = sum;
        }
        double[] dp2 = new double[1 << n];
        dp2[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    dp2[i | (1 << j)] += dp2[i] * a[j] / (total / 2 - count[i]);
                }
            }
        }
        double ans = 0;
        for (int i = 0; i <
    }
}