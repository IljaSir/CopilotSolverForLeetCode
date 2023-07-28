class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.abs(nums[i] - nums[i - 1]);
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            max1 = Math.max(max1, Math.abs(nums[i] - nums[0]) - Math.abs(nums[i] - nums[i - 1]));
            max2 = Math.max(max2, Math.abs(nums[i - 1] - nums[n - 1]) - Math.abs(nums[i] - nums[i - 1]));
            min1 = Math.min(min1, Math.abs(nums[i] - nums[0]) - Math.abs(nums[i] - nums[i - 1]));
            min2 = Math.min(min2, Math.abs(nums[i - 1] - nums[n - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        max1 = Math.max(max1, Math.abs(nums[0] - nums[n - 1]));
        max2 = Math.max(max2, Math.abs(nums[0] - nums[n - 1]));
        return ans + Math.max(Math.max(max1, max2), Math.max(min1, min2));
    }
}