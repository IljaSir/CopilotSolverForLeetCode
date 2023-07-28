class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, getMaxArea(height));
        }
        return maxArea;
    }

    private int getMaxArea(int[] height) {
        int[] stack = new int[height.length];
        int top = -1;
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            while (top >= 0 && height[stack[top]] > height[i]) {
                int h = height[stack[top--]];
                int w = top == -1 ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack[++top] = i;
        }
        while (top >= 0) {
            int h = height[stack[top--]];
            int w = top == -1 ? height.length : height.length - stack[top] - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }
}