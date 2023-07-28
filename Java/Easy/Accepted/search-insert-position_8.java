class Solution {
    public int searchInsert(int[] nums, int target) {
        
        return searchInsert(nums, target, 0, nums.length - 1);
    }
    
    private int searchInsert(int[] nums, int target, int start, int end) {
        if (start == end) {
            return target <= nums[start] ? start : start + 1;
        }
        int mid = (start + end) / 2;
        if (target <= nums[mid]) {
            return searchInsert(nums, target, start, mid);
        } else {
            return searchInsert(nums, target, mid + 1, end);
        }
    }
}