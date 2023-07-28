class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == pivot) {
                j++;
            } else {
                int k = j + 1;
                while (k < n && nums[k] > pivot) {
                    k++;
                }
                if (k == n) {
                    break;
                }
                swap(nums, j, k);
            }
        }
        return nums;
    }
}