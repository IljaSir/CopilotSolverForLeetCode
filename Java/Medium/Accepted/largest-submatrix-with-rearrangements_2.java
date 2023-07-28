class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }
            int[] sortedHeight = Arrays.copyOf(height, n);
            Arrays.sort(sortedHeight);
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, sortedHeight[j] * (n - j));
            }
        }
        return maxArea;
    }
}