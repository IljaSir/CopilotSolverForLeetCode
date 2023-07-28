class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == 'a' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        int min = n;
        for (int i = 0; i < n; i++) {
            int a = dp[i];
            int b = n - i - 1 - (dp[n - 1] - dp[i]);
            min = Math.min(min, a + b);
        }
        return min;
    }
}