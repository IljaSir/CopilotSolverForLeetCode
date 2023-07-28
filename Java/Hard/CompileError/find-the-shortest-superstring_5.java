class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlaps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int m = Math.min(words[i].length(), words[j].length());
                    for (int k = m; k >= 0; k--) {
                        if (words[i].endsWith(words[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int mask = 0; mask < (1 << n); mask++) {
            Arrays.fill(parent[mask], -1);
            for (int bit = 0; bit < n; bit++) {
                if (((mask >> bit) & 1) > 0) {
                    int pmask = mask ^ (1 << bit);
                    if (pmask == 0) continue;
                    for (int i = 0; i < n; i++) {
                        if (((pmask >> i) & 1) > 0) {
                            int val = dp[pmask][i] + overlaps[i][bit];
                            if (val > dp[mask][bit]) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
            }
        }
        int[] perm = new int[n];
        int t = 0;
        int mask = (1 << n) - 1;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] > dp[(1 << n) - 1][p]) {
                p = i;
            }
        }
        while (p >= 0) {
            perm[t++] = p;
            int next = parent[mask][p];
            mask ^= (1 << p);
            p = next;
        }
        String ans = words[perm[n - 1]];
        for (int i = n - 2; i >= 0; i--) {
            int overlap = overlaps[perm
    }
}