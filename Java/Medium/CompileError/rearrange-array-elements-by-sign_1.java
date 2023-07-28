class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
            if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
        return nums;
    }
}