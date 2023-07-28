class Solution {
    public long sumScores(String s) {
        
        int n = s.length();
        long ans = 0;
        int[] dp = new int[n];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[j] = i > 0 ? dp[j + 1] + 1 : 1;
            }
            ans += dp[j];
        }
        return ans;
    }
}