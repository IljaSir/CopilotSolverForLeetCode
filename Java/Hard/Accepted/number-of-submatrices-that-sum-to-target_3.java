class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }
        int res = 0;
        for (int x1 = 0; x1 < m; x1++) {
            for (int x2 = x1; x2 < m; x2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int y = 0; y < n; y++) {
                    int sumij = sum[x2 + 1][y + 1] - sum[x1][y + 1];
                    res += map.getOrDefault(sumij - target, 0);
                    map.put(sumij, map.getOrDefault(sumij, 0) + 1);
                }
            }
        }
        return res;
    }
}