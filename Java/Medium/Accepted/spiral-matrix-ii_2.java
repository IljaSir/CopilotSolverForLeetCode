class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i=left; i<=right; i++) {
                matrix[top][i] = num++;
            }
            for (int i=top+1; i<=bottom; i++) {
                matrix[i][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int i=right-1; i>left; i--) {
                    matrix[bottom][i] = num++;
                }
                for (int i=bottom; i>top; i--) {
                    matrix[i][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}