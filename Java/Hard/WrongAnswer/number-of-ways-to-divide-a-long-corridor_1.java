class Solution {
    public int numberOfWays(String corridor) {
        
        final int MOD = 1000000007;
        int n = corridor.length();
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + (corridor.charAt(i) == 'S' ? 1 : 0);
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (corridor.charAt(i - 1) == 'P') {
                f[i] = f[i - 1];
            } else {
                f[i] = (int) ((f[i - 1] * 1L * (s[i] - 1)) % MOD);
            }
        }
        return f[n];
    }
}