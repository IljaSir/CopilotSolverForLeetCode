class Solution {
    public int longestSubarray(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i > 0 ? left[i - 1] & nums[i] : nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = i < n - 1 ? right[i + 1] & nums[i] : nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, left[i] & right[i + 1]);
        }
        return ans;
    }
}