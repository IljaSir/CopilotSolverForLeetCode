class Solution {
    public String shortestSuperstring(String[] words) {
        
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    overlap[i][j] = calOverlap(words[i], words[j]);
                }
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(parent[i], -1);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = words[j].length();
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] + overlap[k][j] > dp[i][j]) {
                                dp[i][j] = dp[prev][k] + overlap[k][j];
                                parent[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] > dp[(1 << n) - 1][idx]) {
                idx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        while (idx != -1) {
            int prev = cur - (1 << idx);
            if (prev == 0) {
                sb.append(words[idx]);
            } else {
                sb.append(words[idx].substring(words[idx].length() - overlap[parent[cur][idx]][idx]));
            }
            cur = prev;
            idx = parent[cur][idx];
        }
        return sb.reverse().toString();
    }
}