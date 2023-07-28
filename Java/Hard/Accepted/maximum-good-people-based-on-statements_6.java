class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            boolean[] good = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    good[j] = true;
                }
            }
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        if (statements[j][k] == 0 && good[k]) {
                            valid = false;
                        }
                        if (statements[j][k] == 1 && !good[k]) {
                            valid = false;
                        }
                    }
                }
            }
            if (valid) {
                for (int j = 0; j < n; j++) {
                    if (good[j]) {
                        dp[i]++;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}