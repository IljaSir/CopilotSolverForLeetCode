class Solution {
    public int reversePairs(int[] nums) {
        
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int i = left;
        int j = mid + 1;
        int t = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid) {
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += j - (mid + 1);
            i++;
        }
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            temp[t++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }
}