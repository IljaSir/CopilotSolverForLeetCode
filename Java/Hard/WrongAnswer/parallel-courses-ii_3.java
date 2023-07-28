class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] pre = new int[n];
        int[] mask = new int[n];
        for (int[] r : relations) {
            pre[r[1] - 1]++;
            mask[r[0] - 1] |= 1 << (r[1] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int s = 0; s < (1 << n); s++) {
            int taken = 0;
            for (int i = 0; i < n; i++) {
                if ((s & (1 << i)) == 0 && pre[i] == 0) {
                    taken |= 1 << i;
                }
            }
            for (int t = taken; t > 0; t = (t - 1) & taken) {
                if (Integer.bitCount(t) > k) {
                    continue;
                }
                int ns = s | t;
                if (ns == s) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if ((t & (1 << i)) > 0) {
                        pre[i]--;
                    }
                }
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if ((s & (1 << i)) == 0 && (mask[i] & ns) != mask[i]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[ns] = Math.min(dp[ns], dp[s] + 1);
                }
                for (int i = 0; i < n; i++) {
                    if ((t & (1 << i)) > 0) {
                        pre[i]++;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}