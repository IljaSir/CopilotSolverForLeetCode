class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        int[] rank = new int[m + n];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                map.computeIfAbsent(matrix[i][j], x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        for (int x : map.keySet()) {
            int[] parent = new int[m + n];
            int[] size = new int[m + n];
            for (int i = 0; i < m + n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int[] ij : map.get(x)) {
                int i = ij[0], j = ij[1], p = find(parent, i), q = find(parent, j + m);
                if (p == q) continue;
                parent[p] = q;
                size[q] += size[p];
            }
            Map<Integer, Integer> group = new HashMap<>();
            for (int i = 0; i < m; ++i) {
                int p = find(parent, i);
                group.put(p, Math.max(group.getOrDefault(p, 0), rank[i]));
            }
            for (int j = 0; j < n; ++j) {
                int p = find(parent, j + m);
                group.put(p, Math.max(group.getOrDefault(p, 0), rank[m + j]));
            }
            for (int[] ij : map.get(x)) {
                int i = ij[0], j = ij[1];
                int p = find(parent, i);
                int val = group.get(p) + 1;
                res[i][j] = val;
                rank[i] = rank[m + j] = val;
            }
        }
        return res;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}