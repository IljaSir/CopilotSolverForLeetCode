class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return true;
        int i = 1;
        while (i < n && nums[i] == nums[i - 1]) i++;
        if (i == n) return true;
        if (nums[i] < nums[i - 1]) {
            while (i < n && nums[i] <= nums[i - 1]) i++;
        } else {
            while (i < n && nums[i] >= nums[i - 1]) i++;
        }
        return i == n;
    }
}