class Solution {
    public int reversePairs(int[] nums) {
        
        int[] cache = new int[nums.length];
        return mergeSort(nums, cache, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int[] cache, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, cache, left, mid) + mergeSort(nums, cache, mid + 1, right);
        int i = left, j = mid + 1, pos = left;
        while (i <= mid) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - mid - 1;
            i++;
        }
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            cache[pos++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            cache[pos++] = nums[i++];
        }
        while (j <= right) {
            cache[pos++] = nums[j++];
        }
        System.arraycopy(cache, left, nums, left, right - left + 1);
        return count;
    }
}