class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        
        int[][] xor = new int[matrix.length][matrix[0].length];
        xor[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            xor[i][0] = xor[i - 1][0] ^ matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            xor[0][i] = xor[0][i - 1] ^ matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                xor[i][j] = xor[i - 1][j] ^ xor[i][j - 1] ^ xor[i - 1][j - 1] ^ matrix[i][j];
            }
        }
        int[] values = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                values[index++] = xor[i][j];
            }
        }
        Arrays.sort(values);
        return values[values.length - k];
    }
}