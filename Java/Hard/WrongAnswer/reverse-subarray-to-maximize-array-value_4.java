class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.abs(nums[i] - nums[i - 1]);
        }
        int maxDiff = 0;
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[0] - nums[i]) - Math.abs(nums[i] - nums[i - 1]));
        }
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        for (int i = 1; i < n - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i + 1] - nums[0]) - Math.abs(nums[i] - nums[i - 1]));
            maxDiff = Math.max(maxDiff, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i + 1] - nums[i]));
            int min = Math.min(nums[i], nums[i - 1]);
            int max = Math.max(nums[i], nums[i - 1]);
            for (int j = i + 1; j < n; j++) {
                maxDiff = Math.max(maxDiff, Math.abs(nums[j] - min) - Math.abs(nums[j] - nums[j - 1]));
                maxDiff = Math.max(maxDiff, Math.abs(nums[j] - max) - Math.abs(nums[j] - nums[j - 1]));
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }
        }
        return sum + maxDiff;
    }
}