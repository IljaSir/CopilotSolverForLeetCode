class Solution {
    public boolean search(int[] nums, int target) {
        
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[m]) {
                if ( targl] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[et < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}