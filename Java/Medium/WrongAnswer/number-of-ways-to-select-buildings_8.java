class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int count = dp[n - 1];
        if (count == 0) {
            return (long) (n - 1) * (n - 2) / 2 % 1000000007;
        }
        if (count % 3 != 0) {
            return 0;
        }
        int target = count / 3;
        long a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == target) {
                a++;
            }
            if (dp[i] == target * 2) {
                b++;
            }
        }
        return a * b % 1000000007;
    }
}