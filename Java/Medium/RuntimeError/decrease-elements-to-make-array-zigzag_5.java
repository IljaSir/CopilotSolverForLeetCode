class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (i == nums.length - 1) {
                    if (nums[i] >= nums[i - 1]) {
                        even += nums[i] - nums[i - 1] + 1;
                    }
                } else {
                    if (nums[i] >= nums[i + 1] || nums[i] >= nums[i - 1]) {
                        even += Math.max(nums[i] - nums[i + 1], nums[i] - nums[i - 1]) + 1;
                    }
                }
            } else {
                if (i == 0) {
                    if (nums[i] >= nums[i + 1]) {
                        odd += nums[i] - nums[i + 1] + 1;
                    }
                } else {
                    if (nums[i] >= nums[i + 1] || nums[i] >= nums[i - 1]) {
                        odd += Math.max(nums[i] - nums[i + 1], nums[i] - nums[i - 1]) + 1;
                    }
                }
            }
        }
        return Math.min(odd, even);
    }
}