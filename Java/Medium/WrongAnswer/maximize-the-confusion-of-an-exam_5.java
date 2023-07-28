class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int[] f = new int[n];
        int[] t = new int[n];
        int[] g = new int[n];
        int[] h = new int[n];
        f[0] = answerKey.charAt(0) == 'F' ? 1 : 0;
        t[0] = answerKey.charAt(0) == 'T' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            f[i] = answerKey.charAt(i) == 'F' ? f[i - 1] + 1 : 0;
            t[i] = answerKey.charAt(i) == 'T' ? t[i - 1] + 1 : 0;
        }
        g[n - 1] = answerKey.charAt(n - 1) == 'F' ? 1 : 0;
        h[n - 1] = answerKey.charAt(n - 1) == 'T' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            g[i] = answerKey.charAt(i) == 'F' ? g[i + 1] + 1 : 0;
            h[i] = answerKey.charAt(i) == 'T' ? h[i + 1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            if (i - k - 1 >= 0) {
                cur = Math.max(cur, f[i - k - 1]);
            }
            if (i + k + 1 < n) {
                cur = Math.max(cur, g[i + k + 1]);
            }
            if (i - k >= 0) {
                cur = Math.max(cur, t[i - k] + k);
            }
            if (i + k < n) {
                cur = Math.max(cur, h[i + k] + k);
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}