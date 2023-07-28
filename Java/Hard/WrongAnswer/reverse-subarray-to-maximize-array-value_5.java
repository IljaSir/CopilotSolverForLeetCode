class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
            maxDiff = Math.max(maxDiff, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            maxDiff = Math.max(maxDiff, Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i] - nums[i + 1]));
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[j]) - Math.abs(nums[i] - nums[i + 1]) - Math.abs(nums[j - 1] - nums[j]));
            }
        }
        return sum + maxDiff;
    }
}