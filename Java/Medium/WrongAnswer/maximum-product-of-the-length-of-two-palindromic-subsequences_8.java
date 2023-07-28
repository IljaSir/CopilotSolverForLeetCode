class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        int[] pal = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                while (l < n && (i & (1 << l)) == 0) {
                    l++;
                }
                while (r >= 0 && (i & (1 << r)) == 0) {
                    r--;
                }
                if (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        pal[i] = 0;
                        break;
                    } else {
                        pal[i] = (l == r ? 1 : 2) + pal[i ^ (1 << l) ^ (1 << r)];
                    }
                    l++;
                    r--;
                }
            }
            if (l == r) {
                pal[i] = 1;
            }
        }
        for (int i = 0; i < (1 << n); i++) {
            for (int j = i; j != 0; j = (j - 1) & i) {
                dp[i] = Math.max(dp[i], pal[j] * pal[i ^ j]);
            }
        }
        return dp[(1 << n) - 1];
    }
}