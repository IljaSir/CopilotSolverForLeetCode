class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            for (int j = i + 1; j < n; j += ans[j] + 1) {
                if (h < heights[j]) {
                    ans[i]++;
                } else if (h == heights[j]) {
                    ans[i] += ans[j];
                    break;
                }
            }
        }
        return ans;
    }
}