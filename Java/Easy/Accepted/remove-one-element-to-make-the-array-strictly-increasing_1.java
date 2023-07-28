class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                count++;
                if (i - 2 < 0 || nums[i] > nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
}