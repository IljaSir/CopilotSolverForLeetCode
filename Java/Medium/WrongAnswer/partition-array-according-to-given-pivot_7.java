class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < pivot) {
                res[i++] = nums[k];
            } else if (nums[k] > pivot) {
                res[j--] = nums[k];
            }
        }
        for (int k = i; k <= j; k++) {
            res[k] = pivot;
        }
        return res;
    }
}