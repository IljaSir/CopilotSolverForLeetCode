class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixXor = new int[m][n];
        int[] xor = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixXor[i][j] = matrix[i][j];
                if (i > 0) {
                    prefixXor[i][j] ^= prefixXor[i - 1][j];
                }
                if (j > 0) {
                    prefixXor[i][j] ^= prefixXor[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixXor[i][j] ^= prefixXor[i - 1][j - 1];
                }
                xor[idx++] = prefixXor[i][j];
            }
        }
        Arrays.sort(xor);
        return xor[m * n - k];
    }
}