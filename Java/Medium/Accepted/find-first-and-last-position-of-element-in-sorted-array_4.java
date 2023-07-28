class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                int i = mid - 1;
                while(i >= 0 && nums[i] == target) {
                    result[0] = i;
                    i--;
                }
                i = mid + 1;
                while(i < nums.length && nums[i] == target) {
                    result[1] = i;
                    i++;
                }
                return result;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}