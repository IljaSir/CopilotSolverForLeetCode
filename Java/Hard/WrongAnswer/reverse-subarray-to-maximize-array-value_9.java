class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            sum += diff;
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(nums[n - 1] - nums[i - 1]) - diff, Math.abs(nums[0] - nums[i]) - diff));
        }
        int maxDiff2 = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxDiff2 = Math.max(maxDiff2, Math.abs(nums[i - 1] - nums[0]) - Math.abs(nums[i] - nums[i - 1]));
            maxDiff2 = Math.max(maxDiff2, Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i] - nums[i - 1]));
        }
        return sum + Math.max(maxDiff, maxDiff2);
    }
}