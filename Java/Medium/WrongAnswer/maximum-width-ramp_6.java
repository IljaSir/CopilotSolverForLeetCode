class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        int ans = 0, j = n - 1;
        for (int i = n - 1; i >= 0; --i) {
            while (j >= 0 && min[j] > nums[i]) {
                --j;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}