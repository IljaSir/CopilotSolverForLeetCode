class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] sum = new int[m];
        for (int i = 0; i < m; i++) {
            sum[i] = mat[i][0];
        }
        for (int i = 1; i < n; i++) {
            int[] sum2 = new int[k];
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    sum2[l] += mat[j][i];
                }
            }
            Arrays.sort(sum2);
            for (int j = 0; j < k; j++) {
                sum[j] += sum2[j];
            }
            Arrays.sort(sum);
        }
        return sum[k - 1];
    }
}