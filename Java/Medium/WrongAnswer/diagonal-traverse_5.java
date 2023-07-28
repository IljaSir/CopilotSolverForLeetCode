class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int k = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                for (int j = Math.min(i, n - 1); j >= Math.max(0, i - m + 1); j--) {
                    ans[k++] = mat[i - j][j];
                }
            }
            else {
                for (int j = Math.max(0, i - m + 1); j <= Math.min(i, n - 1); j++) {
                    ans[k++] = mat[i - j][j];
                }
            }
        }
        return ans;
    }
}