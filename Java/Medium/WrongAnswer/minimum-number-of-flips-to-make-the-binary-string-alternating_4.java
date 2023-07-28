class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = s.charAt(i % n) - '0';
        }
        int[] dp = new int[2 * n];
        for (int i = 1; i < 2 * n; i++) {
            dp[i] = dp[i - 1] + (a[i] == a[i - 1] ? 1 : 0);
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            int l = i, r = i + n - 1;
            int cnt = dp[r] - dp[l];
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}