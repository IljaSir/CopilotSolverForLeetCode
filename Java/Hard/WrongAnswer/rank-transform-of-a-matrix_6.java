class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rank = new int[m][n];
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int[] sorted = map.keySet().stream().mapToInt(i -> i).sorted().toArray();
        for (int val : sorted) {
            int[] parent = new int[m + n];
            for (int i = 0; i < m + n; i++) {
                parent[i] = i;
            }
            for (int[] pos : map.get(val)) {
                int i = pos[0], j = pos[1];
                int p1 = find(parent, i);
                int p2 = find(parent, j + m);
                if (p1 == p2) {
                    continue;
                }
                parent[p1] = p2;
                rowMax[i] = Math.max(rowMax[i], colMax[j]);
                colMax[j] = Math.max(rowMax[i], colMax[j]);
            }
            for (int[] pos : map.get(val)) {
                int i = pos[0], j = pos[1];
                rank[i][j] = rowMax[i] = colMax[j] = Math.max(rowMax[i], colMax[j]) + 1;
            }
        }
        return rank;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}