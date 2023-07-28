class Solution {
    public int numSubmat(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] height = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            ans += count(height);
        }
        return ans;
    }

    private int count(int[] height) {
        int ans = 0;
        int stackTop = -1;
        int[] stack = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while (stackTop >= 0 && height[stack[stackTop]] >= height[i]) {
                stackTop--;
            }
            if (stackTop >= 0) {
                ans += height[stack[stackTop]] * (i - stack[stackTop] - 1);
            } else {
                ans += height[i] * (i + 1);
            }
            stack[++stackTop] = i;
        }
        while (stackTop >= 0) {
            ans += height[stack[stackTop]] * (height.length - stack[stackTop] - 1);
            stackTop--;
        }
        return ans;
    }
}