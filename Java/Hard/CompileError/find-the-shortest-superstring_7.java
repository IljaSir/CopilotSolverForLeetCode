class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (i != j) {
                    int m = Math.min(words[i].length(), words[j].length());
                    for (int k = m; k >= 0; --k)
                        if (words[i].endsWith(words[j].substring(0, k))) {
                            overlap[i][j] = k;
                            break;
                        }
                }

        int[][] dp = new int[1<<n][n];
        int[][] parent = new int[1<<n][n];
        for (int mask = 0; mask < (1<<n); ++mask)
            Arrays.fill(parent[mask], -1);

        for (int mask = 0; mask < (1<<n); ++mask) {
            for (int bit = 0; bit < n; ++bit) {  // Let's try to start with bit
                if (((mask >> bit) & 1) > 0) {  // That bit is set in mask
                    // Let's try to find dp[mask][bit].  Previously, we had
                    // a collection of items represented by pmask.
                    int pmask = mask ^ (1 << bit);
                    if (pmask == 0) continue;
                    for (int i = 0; i < n; ++i) {  // Which item i to append?
                        if (((pmask >> i) & 1) > 0) {  // Can we append i to existing collection?
                            // For each bit in pmask, calculate the value
                            // if we ended with word 'i'.
                            int val = dp[pmask][i] + overlap[i][bit];
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
            if (dp[(1<<n)-1][j] > dp[(1<<n)-
    }
}