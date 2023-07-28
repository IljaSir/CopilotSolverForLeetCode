class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int m = Math.min(words[i].length(), words[j].length());
                    for (int k = m; k >= 0; k--) {
                        if (words[i].endsWith(words[j].substring(0, k))) {
                            overlap[i][j] = k;
                            break;
                        }
                    }
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
                            int val = dp[pmask][i] + words[bit].length() - overlap[i][bit];
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
        int t = (1 << n) - 1;
        int min = Integer.MAX_VALUE;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (dp[t][i] < min) {
                min = dp[t][i];
                last = i;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            perm[i] = last;
            int temp = last;
            last = parent[t][last];
            t
    }
}