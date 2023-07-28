class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1 < 0 ? Integer.MAX_VALUE : nums[i - 1];
            int right = i + 1 >= nums.length ? Integer.MAX_VALUE : nums[i + 1];
            int min = Math.min(left, right);
            if (i % 2 == 0) {
                if (nums[i] >= min) {
                    even += nums[i] - min + 1;
                }
            } else {
                if (nums[i] >= min) {
                    odd += nums[i] - min + 1;
                }
            }
        }
        return Math.min(odd, even);
    }
}