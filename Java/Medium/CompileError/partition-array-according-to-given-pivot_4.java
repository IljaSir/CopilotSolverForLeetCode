class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int i = 0, j = nums.length - 1, k = 0;
        while (k <= j) {
            if (nums[k] < pivot) {
                swap(nums, i++, k++);
            } else if (nums[k] > pivot) {
                swap(nums, k, j--);
            } else {
                k++;
            }
        }
        return nums;
    }
}