class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] primes = new int[]{2, 3, 5, 7};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i - j + 1 >= minLength) {
                    int sum = 0;
                    for (int p : primes) {
                        if (s.charAt(j - 1) == p + '0') {
                            sum++;
                            break;
                        }
                    }
                    for (int p : primes) {
                        if (s.charAt(i - 1) == p + '0') {
                            sum++;
                            break;
                        }
                    }
                    if (sum == 2) {
                        dp[i] = (dp[i] + dp[j - 1]) % 1000000007;
                    }
                }
            }
        }
        int[] sum = new int[n + 1];
        sum[0] = dp[0];
        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + dp[i]) % 1000000007;
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i - j + 1 >= minLength) {
                    ans[i] = (ans[i] + ans[j - 1] * (sum[i] - sum[j - 1])) % 1000000007;
                }
            }
        }
        return ans[n];
    }
}