class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        int[] suf = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1] + (s.charAt(i) == 'b' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, pre[i] + suf[i]);
        }
        return ans;
    }
}