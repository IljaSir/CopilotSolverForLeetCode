class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i == 0) {
                    nums[i] = nums[i + 1];
                } else {
                    if (nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                }
                count++;
            }
        }
        return count <= 1;
    }
}