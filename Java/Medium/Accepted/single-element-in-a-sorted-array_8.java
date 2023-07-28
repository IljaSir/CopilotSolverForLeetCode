class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] == nums[m ^ 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}