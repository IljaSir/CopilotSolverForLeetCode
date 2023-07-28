class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int same = 0;
            int diff = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    same++;
                } else {
                    diff++;
                }
                for (int l = 0; l <= k; l++) {
                    if (l >= diff) {
                        int cur = dp[i][l - diff];
                        if (same == 1) {
                            cur++;
                        } else if (same < 10) {
                            cur += 2;
                        } else if (same < 100) {
                            cur += 3;
                        } else {
                            cur += 4;
                        }
                        dp[j + 1][l] = Math.min(dp[j + 1][l], cur);
                    }
                }
            }
        }
        return dp[n][k];
    }
}