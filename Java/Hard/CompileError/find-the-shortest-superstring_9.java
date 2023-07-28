class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlaps = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    int m = Math.min(words[i].length(), words[j].length());
                    for (int k = m; k >= 0; --k) {
                        if (words[i].endsWith(words[j].substring(0, k))) {
                            overlaps[i][j] = k;
                            break;
                        }
                    }
                }
            }
        }

        int[][] dp = new int[1<<n][n];
        int[][] parent = new int[1<<n][n];
        for (int mask = 0; mask < (1<<n); ++mask)
            Arrays.fill(parent[mask], -1);

        for (int mask = 0; mask < (1<<n); ++mask) {
            for (int bit = 0; bit < n; ++bit) { // There is a bit on in the mask
                if (((mask >> bit) & 1) > 0) { // If bit is on in the mask
                    int pmask = mask ^ (1 << bit); // Flip the bit
                    if (pmask == 0) continue;
                    for (int i = 0; i < n; ++i) { // Iterate over bits that are on in the pmask
                        if (((pmask >> i) & 1) > 0) { // If i-th bit is on in the pmask
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
        int t = 0, mask = (1<<n) - 1;
        for (int j = 0; j < n; ++j)
            if (dp[(1<<n)-1][j] > dp[(1<<n)-1][t])
                t = j;
        while (t != -1) {
            perm[--n] = t;
            int p = parent[mask
    }
}