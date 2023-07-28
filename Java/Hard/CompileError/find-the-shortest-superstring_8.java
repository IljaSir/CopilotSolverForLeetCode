class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i][j] = getOverlap(words[i], words[j]);
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
                    if (pmask == 0) {
                        continue;
                    }
                    for (int i = 0; i < n; i++) {
                        if (((pmask >> i) & 1) > 0) {
                            int val = dp[pmask][i] + graph[i][bit];
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
        int t = (1 << n) - 1;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (dp[t][i] > dp[t][p]) {
                p = i;
            }
        }
        int idx = n - 1;
        while (t > 0) {
            perm[idx--] = p;
            int temp = parent[t][p];
            t = t ^ (1 << p);
            p = temp;
        }
        StringBuilder sb = new StringBuilder(words[perm[0]]);
        for (int i = 1; i < n; i++) {
            int overlap = graph[perm[i - 1]][perm[i]];
            sb.append(words[perm[i]].substring(overlap));
        }
        return sb.toString();
    }
}