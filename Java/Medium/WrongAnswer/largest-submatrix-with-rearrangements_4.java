class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(height);
            for (int j = 0; j < n; j++) {
                res = Math.max(res, height[j] * (n - j));
            }
        }
        return res;
    }
}