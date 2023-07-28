class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int i = 0, j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < pivot) {
                swap(nums, i, k);
                i++;
            }
        }
        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] > pivot) {
                swap(nums, j, k);
                j++;
            }
        }
        return nums;
    }
}