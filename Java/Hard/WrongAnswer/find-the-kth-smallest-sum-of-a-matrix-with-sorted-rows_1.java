class Solution {
    public int kthSmallest(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] sum = new int[m];
        for (int i = 0; i < m; i++) {
            sum[i] = mat[i][0];
        }
        for (int i = 1; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                temp[j] = sum[j] + mat[j][i];
            }
            Arrays.sort(temp);
            for (int j = 0; j < m; j++) {
                sum[j] = temp[j];
            }
        }
        return sum[m - 1];
    }
}