class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        int i = 0;
        while (i < n - 1 && nums[i] == nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return true;
        }
        boolean isIncreasing = nums[i] < nums[i + 1];
        for (i = i + 1; i < n - 1; i++) {
            if (isIncreasing) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}