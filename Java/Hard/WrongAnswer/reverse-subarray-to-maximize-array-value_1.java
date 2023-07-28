class Solution {
    public int maxValueAfterReverse(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, Math.max(nums[i], nums[i + 1]));
            min = Math.min(min, Math.min(nums[i], nums[i + 1]));
        }
        int ans = sum;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, sum - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - max));
            ans = Math.max(ans, sum - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i + 1] - max));
            ans = Math.max(ans, sum - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i] - min));
            ans = Math.max(ans, sum - Math.abs(nums[i] - nums[i + 1]) + Math.abs(nums[i + 1] - min));
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i] - nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i + 1] - nums[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, sum - Math.abs(nums[i] - nums[i + 1]) + left[i]);
            ans = Math.max(ans, sum - Math.abs(nums[i] - nums[i + 1]) + right[i + 1]);
        }
        return ans;
    }
}