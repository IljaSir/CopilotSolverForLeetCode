class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    private int rob(int[] nums, int left, int right) {
        int first = nums[left], second = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}