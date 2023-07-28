class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] f = new int[k + 1];
        int[] g = new int[k + 1];
        int[] h = new int[k + 1];
        int[] dp = new int[k + 1];
        int l = 0, r = 0;
        int res = n + 1;
        for (int i = 0; i < n; ++i) {
            int x = rolls[i];
            f[x]++;
            if (f[x] == 1) {
                g[x] = i;
            }
            h[x] = i;
            while (l < r && f[dp[l]] > 1) {
                f[dp[l]]--;
                l++;
            }
            if (r - l + 1 < k) {
                dp[r++] = x;
            } else {
                res = Math.min(res, h[dp[l]] - g[dp[l]] + 1);
            }
        }
        return res <= n ? res : -1;
    }
}