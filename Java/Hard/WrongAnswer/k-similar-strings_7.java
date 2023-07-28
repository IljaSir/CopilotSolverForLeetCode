class Solution {
    public int kSimilarity(String s1, String s2) {
        
        int n = s1.length();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) {
                    dist[i][j] = 1;
                    dist[j][i] = 1;
                }
            }
        }
        int[] d = new int[1 << n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            int[] q = p.clone();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    q[j] = find(q, j);
                }
            }
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) {
                    for (int k = j + 1; k < n; k++) {
                        if (((i >> k) & 1) == 0 && dist[j][k] == 1) {
                            int nj = find(q, j);
                            int nk = find(q, k);
                            if (nj != nk) {
                                d[i | (1 << j) | (1 << k)] = Math.min(d[i | (1 << j) | (1 << k)], d[i] + 1);
                            }
                        }
                    }
                }
            }
        }
        return d[(1 << n) - 1];
    }
    
    int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
}