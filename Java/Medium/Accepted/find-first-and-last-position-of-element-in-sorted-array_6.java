class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int leftIndex = mid;
                int rightIndex = mid;
                while (leftIndex - 1 >= 0 && nums[leftIndex - 1] == target) {
                    leftIndex--;
                }
                while (rightIndex + 1 < nums.length && nums[rightIndex + 1] == target) {
                    rightIndex++;
                }
                result[0] = leftIndex;
                result[1] = rightIndex;
                return result;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}