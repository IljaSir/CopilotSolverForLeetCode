class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(nums[i] - nums[i + 1]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, Math.min(nums[i], nums[i + 1]));
            min = Math.min(min, Math.max(nums[i], nums[i + 1]));
            max2 = Math.max(max2, Math.abs(nums[i] - nums[i + 1]) - Math.abs(nums[0] - nums[n - 1]));
            min2 = Math.min(min2, Math.abs(nums[i] - nums[i + 1]) - Math.abs(nums[0] - nums[n - 1]));
        }
        return ans + Math.max(0, Math.max(max - min, max2 - min2));
    }
}