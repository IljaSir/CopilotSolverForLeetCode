class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                max += min - height[i];
            }
        }
        return max;
    }
}