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
                if (((mask >> bit) & 1) > 0) {  // That bit is set in mask. Let's try to remove it from mask
                    int pmask = mask ^ (1 << bit);  // pmask is parent of mask
                    if (pmask == 0) continue;
                    for (int i = 0; i < n; ++i) {  // Let's try to append bit to string ending with i
                        if (dp[mask][bit] < dp[pmask][i] + overlap[i][bit]) {
                            dp[mask][bit] = dp[pmask][i] + overlap[i][bit];
                            parent[mask][bit] = i;
                        }
                    }
                }
            }
        }

        int[] perm = new int[n];
        int t = 0, mask = (1<<n) - 1;
        for (int j = 0; j < n; ++j)
            if (dp[(1<<n)-1][t] < dp[(1<<n)-1][j])
                t = j;
        while (mask > 0) {
            perm[--n] = t;
            int p = parent[mask][t];
            mask ^= (1 << t);
            t = p;
        }
    }
}