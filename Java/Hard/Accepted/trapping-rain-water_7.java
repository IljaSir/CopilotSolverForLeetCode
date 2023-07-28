class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                rightMax[i] = height[i];
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}