class Solution {
    public int longestAwesome(String s) {
        
        int n = s.length(), res = 0;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] ^ (1 << (s.charAt(i) - '0'));
        }
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, n);
        dp[0] = -1;
        for (int i = 0; i <= n; i++) {
            int cur = a[i];
            res = Math.max(res, i - dp[cur]);
            for (int j = 0; j < 10; j++) {
                res = Math.max(res, i - dp[cur ^ (1 << j)]);
            }
            dp[cur] = Math.min(dp[cur], i);
        }
        return res;
    }
}