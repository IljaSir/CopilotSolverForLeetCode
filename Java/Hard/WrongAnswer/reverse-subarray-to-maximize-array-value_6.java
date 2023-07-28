class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int maxDiff = 0;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            sum += diff;
            maxDiff = Math.max(maxDiff, Math.abs(nums[0] - nums[i]) - diff);
            maxDiff = Math.max(maxDiff, Math.abs(nums[n - 1] - nums[i - 1]) - diff);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n && j < i + 4; j++) {
                maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[j]) - Math.abs(nums[i + 1] - nums[j - 1]));
            }
        }
        return sum + maxDiff;
    }
}