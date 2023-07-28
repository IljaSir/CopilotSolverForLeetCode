class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            sum += diff;
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(nums[i] - nums[0]) - diff, Math.abs(nums[i + 1] - nums[n - 1]) - diff));
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int diff = Math.abs(nums[i] - nums[j + 1]) - Math.abs(nums[i] - nums[i + 1]) - Math.abs(nums[j] - nums[j + 1]);
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        return sum + maxDiff;
    }
}