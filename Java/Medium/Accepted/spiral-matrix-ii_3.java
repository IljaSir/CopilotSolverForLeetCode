class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            // 从上到下
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = num++;
            }
            // 从右到左
            for (int i = right - 1; i >= left; i--) {
                res[bottom][i] = num++;
            }
            // 从下到上
            for (int i = bottom - 1; i > top; i--) {
                res[i][left] = num++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}