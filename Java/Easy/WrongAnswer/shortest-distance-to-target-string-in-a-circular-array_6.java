class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = words[i].equals(target) ? i : n;
            dp2[i] = words[i].equals(target) ? i : n;
        }
        for (int i = 0; i < n; i++) {
            dp[(i + 1) % n] = Math.min(dp[(i + 1) % n], dp[i] + 1);
            dp2[(i + n - 1) % n] = Math.min(dp2[(i + n - 1) % n], dp2[i] + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, Math.min(dp[i], dp2[i]));
        }
        return res == n ? -1 : res;
    }
}