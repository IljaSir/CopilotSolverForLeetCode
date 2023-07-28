class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, l++);
            } else if (nums[i] > pivot) {
                swap(nums, i--, r--);
            }
        }
        return nums;
    }
}