class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int even = 0;
        int odd = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i == n - 1 ? Integer.MAX_VALUE : nums[i + 1];
            int min = Math.min(left, right);
            if (i % 2 == 0) {
                even += Math.max(nums[i] - min + 1, 0);
            } else {
                odd += Math.max(nums[i] - min + 1, 0);
            }
        }
        return Math.min(even, odd);
    }
}