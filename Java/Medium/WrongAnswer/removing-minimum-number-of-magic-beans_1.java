class Solution {
    public long minimumRemoval(int[] beans) {
        
        int max = 0;
        for (int bean : beans) {
            max = Math.max(max, bean);
        }
        int[] counts = new int[max + 1];
        for (int bean : beans) {
            counts[bean]++;
        }
        long[] sums = new long[max + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + counts[i];
        }
        int[] divisors = new int[max + 1];
        for (int i = 1; i < divisors.length; i++) {
            divisors[i] = 1;
        }
        for (int i = 2; i < divisors.length; i++) {
            if (divisors[i] == 1) {
                for (int j = i; j < divisors.length; j += i) {
                    divisors[j]++;
                }
            }
        }
        long[] dp = new long[max + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = sums[i];
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i / j] - sums[j] - sums[i / j]);
                }
            }
        }
        long result = Long.MAX_VALUE;
        for (int i = 1; i <= max; i++) {
            result = Math.min(result, dp[i] - sums[i] + counts[i]);
        }
        return result;
    }
}