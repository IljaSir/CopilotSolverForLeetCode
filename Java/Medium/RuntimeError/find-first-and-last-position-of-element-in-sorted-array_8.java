class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = left;
        right = nums.length - 1;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        result[1] = right;
        return result;
    }
}