class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[][] index = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                index[i][j] = i * n + j;
            }
        }
        int[] rank = new int[m + n];
        for (int[] row : matrix) {
            int[] tmp = Arrays.copyOf(row, n);
            Arrays.sort(tmp);
            for (int i = 0; i < n; i++) {
                if (i == 0 || tmp[i] != tmp[i - 1]) {
                    int[] pos = new int[m];
                    int cnt = 0;
                    for (int j = 0; j < m; j++) {
                        if (matrix[j][i] == tmp[i]) {
                            pos[cnt++] = j;
                        }
                    }
                    for (int k = 0; k < cnt; k++) {
                        for (int l = k + 1; l < cnt; l++) {
                            int x = pos[k];
                            int y = pos[l];
                            int rx = find(index, x * n + i);
                            int ry = find(index, y * n + i);
                            if (rx != ry) {
                                if (rx > ry) {
                                    int t = rx;
                                    rx = ry;
                                    ry = t;
                                }
                                index[ry / n][ry % n] = rx;
                                rank[rx / n] = Math.max(rank[rx / n], rank[ry / n]);
                                rank[rx % n + m] = Math.max(rank[rx % n + m], rank[ry % n + m]);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = find(index, i * n + j);
                res[i][j] = Math.max(rank[r / n], rank[r % n + m]) + 1;
            }
        }
        return res;
    }
}