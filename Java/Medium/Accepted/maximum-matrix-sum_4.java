class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int n = matrix.length;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = matrix[i][j];
                if (x < 0) {
                    count++;
                    x = -x;
                }
                min = Math.min(min, x);
                sum += x;
            }
        }
        return count % 2 == 0 ? sum : sum - min * 2;
    }
}