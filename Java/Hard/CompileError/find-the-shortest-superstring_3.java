class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    overlap[i][j] = overlap(words[i], words[j]);
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = words[i].length();
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int bit = 0; bit < n; bit++) {
                if (((mask >> bit) & 1) > 0) {
                    int pmask = mask ^ (1 << bit);
                    for (int i = 0; i < n; i++) {
                        if (((pmask >> i) & 1) > 0) {
                            int val = dp[pmask][i] + overlap[i][bit];
                            if (val < dp[mask][bit]) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
            }
        }
        int[] perm = new int[n];
        int last = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] < min) {
                min = dp[(1 << n) - 1][i];
                last = i;
            }
        }
        int t = (1 << n) - 1;
        for (int i = n - 1; i >= 0; i--) {
            perm[i] = last;
            int temp = last;
            last = parent[t][last];
            t ^= (1 << temp);
        }
        StringBuilder sb = new StringBuilder(words[perm[0]]);
        for (int i = 1; i < n; i++) {
            int overlapLength = overlap[perm
    }
}