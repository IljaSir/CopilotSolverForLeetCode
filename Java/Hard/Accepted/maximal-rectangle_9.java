class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int maxArea = 0;
        int rows = matrix.length;
        if (rows == 0) {
            return maxArea;
        }
        int cols = matrix[0].length;
        int[] dp = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[j]++;
                } else {
                    dp[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int curHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}