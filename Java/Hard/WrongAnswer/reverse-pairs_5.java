class Solution {
    public int reversePairs(int[] nums) {
        
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int cnt = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        int[] cache = new int[r - l + 1];
        while (i <= mid) {
            while (j <= r && (long)nums[i] > 2 * (long)nums[j]) {
                j++;
            }
            cnt += j - mid - 1;
            while (j <= r && nums[i] >= nums[j]) {
                cache[k++] = nums[j++];
            }
            cache[k++] = nums[i++];
        }
        while (j <= r) {
            cache[k++] = nums[j++];
        }
        System.arraycopy(cache, 0, nums, l, cache.length);
        return cnt;
    }
}