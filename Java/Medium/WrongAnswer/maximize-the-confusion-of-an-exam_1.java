class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int[] t = new int[n];
        int[] f = new int[n];
        t[0] = answerKey.charAt(0) == 'T' ? 1 : 0;
        f[0] = answerKey.charAt(0) == 'F' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            t[i] = answerKey.charAt(i) == 'T' ? t[i - 1] + 1 : 0;
            f[i] = answerKey.charAt(i) == 'F' ? f[i - 1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i + k - 1;
            if (j >= n) {
                break;
            }
            int tt = t[j] - (i == 0 ? 0 : t[i - 1]);
            int ff = f[j] - (i == 0 ? 0 : f[i - 1]);
            ans = Math.max(ans, Math.max(tt, ff));
        }
        return ans + k;
    }
}