class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] < pivot) {
                swap(nums, i, left);
                i++;
                left++;
            } else if (nums[i] > pivot) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
        return nums;
    }
}