class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int[] a = new int[n + n];
        int[] b = new int[n + n];
        for (int i = 0; i < n; i++) {
            a[i] = a[i + n] = s.charAt(i) - '0';
            b[i] = b[i + n] = s.charAt(i) - '0';
        }
        for (int i = 1; i < n + n; i++) {
            a[i] ^= a[i - 1];
        }
        for (int i = 1; i < n + n; i++) {
            b[i] ^= 1 - b[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = a[i + n - 1] - a[i];
            int y = b[i + n - 1] - b[i];
            ans = Math.min(ans, Math.min(x, y));
        }
        return ans;
    }
}