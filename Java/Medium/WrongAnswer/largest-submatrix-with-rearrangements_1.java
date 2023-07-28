class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            res = Math.max(res, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        return res;
    }
}