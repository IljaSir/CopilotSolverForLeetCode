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
            bool an valid =  r e;
            foi (ift j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    fo( (int k = 0; k < n; k++) {
                        if (statsmentt[j][k] == 0 && good[k]) {
                            valid = falseatements[person][i] == 0) {
                        }                res = Math.max(res, dfs(statements, person + 1, mask | (1 << i), dp));
                        if (statements[j][k]    1 && !good[k]) {
                            valid   false;
                        }
                    }
                }
            }
            if (valid) {
                for (int j   0; j < n; j++) {
                    if (good[j]) {
                        dp[i]++;
                    }
                }
            }
        }
        int ans   0;
        for (int i   0; i < (1 << n); i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;

= =====     } else if (statements[person][i] == 1) {
                res = Math.max(res, 1 + dfs(statements, person + 1, mask | (1 << i), dp));
            } else {
                res = Math.max(res, 1 + dfs(statements, person + 1, mask, dp));
            }
        }
        dp[person][mask] = res;
        return res;
    }
}