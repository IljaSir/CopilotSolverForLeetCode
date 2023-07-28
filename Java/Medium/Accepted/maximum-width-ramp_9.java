class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];
        minLeft[0] = nums[0];
        maxRight[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i]);
            maxRight[n - i - 1] = Math.max(maxRight[n - i], nums[n - i - 1]);
        }
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (minLeft[i] <= maxRight[j]) {
                ans = Math.max(ans, j - i);
                ++j;
            } else {
                ++i;
            }
        }
        return ans;
    }
}