class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int c = 1; c <= n; c++) {
                    int sum = preSum[j][c] - preSum[i - 1][c];
                    Integer num = set.ceiling(sum - k);
                    if (num != null) {
                        max = Math.max(max, sum - num);
                    }
                    set.add(sum);
                }
            }
        }
        return max;
    }
}