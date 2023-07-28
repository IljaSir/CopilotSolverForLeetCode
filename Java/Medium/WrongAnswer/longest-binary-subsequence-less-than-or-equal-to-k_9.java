class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] next = new int[n];
        int[] pre = new int[n];
        int[] cnt = new int[n];
        int[] digits = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - '0';
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                dp[i] = 1;
                next[i] = i + 1;
                pre[i] = i - 1;
                cnt[i] = 1;
                digits[i] = 0;
                res = Math.max(res, dp[i]);
            } else {
                dp[i] = 0;
                next[i] = -1;
                pre[i] = -1;
                cnt[i] = 0;
                digits[i] = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 0) {
                continue;
            }
            int j = i + 1;
            int cur = 0;
            int c = 0;
            while (j < n && cur + (1 << c) <= k) {
                cur += (1 << c);
                c++;
                if (a[j] == 1) {
                    if (dp[j] + cnt[j] > dp[i]) {
                        dp[i] = dp[j] + cnt[j];
                        next[i] = next[j];
                        pre[i] = j;
                        cnt[i] = cnt[j] + 1;
                        digits[i] = c - 1;
                    }
                }
                j = next[j];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}