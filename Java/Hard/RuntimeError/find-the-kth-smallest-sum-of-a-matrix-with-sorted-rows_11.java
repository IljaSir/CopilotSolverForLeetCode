class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length, n = mat[0].length;
        int[] sum = new int[m];
        for (int[] row : mat) {
            sum[0] += row[0];
        }
        for (int i = 1; i < m; i++) {
            int[] nextSum = new int[i + 1];
            Arrays.fill(nextSum, Integer.MAX_VALUE);
            for (int j = 0; j <= i; j++) {
                for (int p = 0; p < n; p++) {
                    nextSum[j] = Math.min(nextSum[j], sum[j == 0 ? 0 : j - 1] + mat[i][p]);
                }
            }
            sum = nextSum;
        }
        Arrays.sort(sum);
        return sum[k - 1];
    }
}