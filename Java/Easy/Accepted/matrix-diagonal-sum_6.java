class Solution {
    public int diagonalSum(int[][] mat) {
        
        int sum = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            sum += mat[i][i];
            sum += mat[i][len - 1 - i];
        }
        if (len % 2 == 1) {
            sum -= mat[len / 2][len / 2];
        }
        return sum;
    }
}