class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = (i == 0 ? 0 : pre[i - 1]) + (s.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = (i == n - 1 ? 0 : suf[i + 1]) + (s.charAt(i) == '0' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = (i == 0 ? 0 : pre[i - 1]) + (i == n - 1 ? 0 : suf[i + 1]);
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}