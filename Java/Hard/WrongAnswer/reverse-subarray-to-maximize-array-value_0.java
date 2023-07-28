class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        int maxGain = 0;
        for (int i = 0; i < n - 1; i++) {
            maxGain = Math.max(maxGain, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            maxGain = Math.max(maxGain, Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i] - nums[i + 1]));
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(sorted, nums[i]);
            if (j > 0) {
                maxGain = Math.max(maxGain, Math.abs(sorted[j - 1] - nums[i]) - Math.abs(nums[i] - sorted[j]));
            }
            if (j + 1 < n) {
                maxGain = Math.max(maxGain, Math.abs(sorted[j + 1] - nums[i]) - Math.abs(nums[i] - sorted[j]));
            }
        }
        return sum + maxGain;
    }
}