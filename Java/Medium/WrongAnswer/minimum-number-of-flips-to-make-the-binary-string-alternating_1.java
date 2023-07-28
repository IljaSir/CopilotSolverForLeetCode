class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            a[i] = s.charAt(i % n) - '0';
        }
        int[] f = new int[n * 2];
        f[0] = a[0];
        for (int i = 1; i < n * 2; i++) {
            f[i] = f[i - 1] + a[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int c = f[i + n - 1] - f[i];
            ans = Math.min(ans, Math.min(c, n - c));
        }
        return ans;
    }
}