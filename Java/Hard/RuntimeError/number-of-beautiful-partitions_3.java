class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int[] count = new int[5];
            int[] sum = new int[5];
            int total = 0;
            for (int j = i; j < n; j++) {
                int d = s.charAt(j) - '0';
                if (d == 1 || d == 9 || d == 4 || d == 6 || d == 8) {
                    break;
                }
                count[d]++;
                if (count[d] >= k) {
                    total++;
                }
                if (j - i + 1 >= minLength) {
                    sum[2] = (sum[2] + dp[i]) % mod;
                    if (d == 2 || d == 3 || d == 5 || d == 7) {
                        sum[3] = (sum[3] + dp[i]) % mod;
                    }
                    if (d == 3 || d == 5 || d == 7) {
                        sum[4] = (sum[4] + dp[i]) % mod;
                    }
                }
            }
            for (int j = 2; j <= 4; j++) {
                dp[j] = (dp[j] + sum[j] - (j > 2 ? sum[j - 1] : 0) + mod) % mod;
            }
        }
        return dp[4];
    }
}