class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        int[] rowMax = new int[m], colMax = new int[n];
        for (int val : map.keySet()) {
            int[] rank = new int[m + n];
            for (int[] ij : map.get(val)) {
                int i = ij[0], j = ij[1];
                rank[i] = Math.max(rank[i], colMax[j]);
                rank[m + j] = Math.max(rank[m + j], rowMax[i]);
            }
            for (int[] ij : map.get(val)) {
                int i = ij[0], j = ij[1];
                res[i][j] = rank[i] = rank[m + j] = rowMax[i] = colMax[j] = Math.max(rank[i], rank[m + j]) + 1;
            }
        }
        return res;
    }
}