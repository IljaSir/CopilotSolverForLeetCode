class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[] rank = new int[m+n];
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        for (int x : map.keySet()) {
            DSU dsu = new DSU(m + n);
            int[] rank2 = rank.clone();
            for (int[] ij : map.get(x)) {
                int i = ij[0], j = ij[1], r = dsu.find(i);
                rank2[r] = Math.max(rank2[r], rank[j + m]);
                dsu.union(i, j + m);
                r = dsu.find(i);
                rank2[r] = Math.max(rank2[r], rank2[j + m] + 1);
            }
            for (int[] ij : map.get(x)) {
                int i = ij[0], j = ij[1];
                res[i][j] = rank[i] = rank[j + m] = rank[dsu.find(i)];
            }
        }
        return res;
    }
}
    }
}