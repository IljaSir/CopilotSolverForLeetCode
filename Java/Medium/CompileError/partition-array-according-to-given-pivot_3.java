class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] < pivot) {
                swap(nums, l, i);
                l++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, r, i);
                r--;
            } else {
                i++;
            }
        }
        return nums;
    }
}