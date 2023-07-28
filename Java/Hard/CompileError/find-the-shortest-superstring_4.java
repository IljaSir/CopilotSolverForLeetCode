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
                dp[i][j] = i == (1 << j) ? words[j].length() : Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    for (int k = 0; k < n; k++) {
                        if (dp[i | (1 << j)][j] > dp[i][k] + words[j].length() - overlap[k][j]) {
                            dp[i | (1 << j)][j] = dp[i][k] + words[j].length() - overlap[k][j];
                            parent[i | (1 << j)][j] = k;
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (min > dp[(1 << n) - 1][i]) {
                min = dp[(1 << n) - 1][i];
                minIdx = i;
            }
        }
        int cur = (1 << n) - 1;
        int[] path = new int[n];
        int size = 0;
        while (minIdx != -1) {
            path[size++] = minIdx;
            int next = parent[cur][minIdx];
            cur = cur ^ (1 << minIdx);
            minIdx = next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[path[--size]]);
        while
    }
}