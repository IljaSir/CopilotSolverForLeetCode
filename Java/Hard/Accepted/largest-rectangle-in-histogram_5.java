class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = i;
            r[i] = i;
        }
        for (int i = 0; i < n; i++) {
            while (l[i] > 0 && heights[l[i] - 1] >= heights[i]) {
                l[i] = l[l[i] - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (r[i] < n - 1 && heights[r[i] + 1] >= heights[i]) {
                r[i] = r[r[i] + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (r[i] - l[i] + 1));
        }
        return ans;
    }
}