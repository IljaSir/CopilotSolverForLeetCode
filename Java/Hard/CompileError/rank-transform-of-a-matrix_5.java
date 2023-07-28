class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        int[] rank = new int[m + n];
        Map<Integer, List<int[]>> map = new HashMap();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                map.computeIfAbsent(matrix[i][j], z-> new ArrayList()).add(new int[]{i, j});

        for (int x: map.keySet()) {
            DSU dsu = new DSU(m + n);
            int[] rank2 = rank.clone();
            for (int[] ij: map.get(x)) {
                int i = ij[0], j = ij[1], ri = dsu.find(i), rj = dsu.find(j + m);
                dsu.union(i, j + m);
                rank2[dsu.find(i)] = Math.max(rank2[ri], rank2[rj]);
            }
            for (int[] ij: map.get(x)) {
                int i = ij[0], j = ij[1];
                ans[i][j] = rank[i] = rank[j + m] = ans[i][j] = rank[dsu.find(i)] + 1;
            }
        }
        return ans;
    }
}
    }
}