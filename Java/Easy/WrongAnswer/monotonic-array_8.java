class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if (nums.length < 3) return true;
        boolean inc = nums[0] <= nums[1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (inc) {
                if (nums[i] > nums[i + 1]) return false;
            } else {
                if (nums[i] < nums[i + 1]) return false;
            }
        }
        return true;
    }
}