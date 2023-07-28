class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    overlap[i][j] = getOverlap(words[i], words[j]);
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(parent[i], -1);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    int prev = i ^ (1 << j);
                    if (prev == 0) {
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if ((prev & (1 << k)) != 0) {
                            int val = dp[prev][k] + overlap[k][j];
                            if (val > dp[i][j]) {
                                dp[i][j] = val;
                                parent[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
        int[] perm = new int[n];
        int t = n - 1;
        int last = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] > max) {
                max = dp[(1 << n) - 1][i];
                last = i;
            }
        }
        while (last != -1) {
            perm[t--] = last;
            int i = (1 << n) - 1;
            int j = last;
            last = parent[i][j];
            i ^= (1 << j);
        }
        StringBuilder sb = new StringBuilder(words[perm[0]]);
        for (int i = 1; i < n; i++) {
            int overlapLen = overlap[perm[i - 1]][perm[i]];
            sb.append(words[perm[i]].substring(overlapLen));
        }
        return sb.toString();
    }
}