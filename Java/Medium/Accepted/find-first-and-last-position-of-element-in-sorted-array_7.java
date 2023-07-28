class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target) {
            return res;
        }
        res[0] = low;
        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        res[1] = high;
        return res;
    }
}