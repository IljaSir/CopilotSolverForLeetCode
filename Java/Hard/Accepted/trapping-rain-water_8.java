class Solution {
    public int trap(int[] height) {
        
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        return ans;
    }
}