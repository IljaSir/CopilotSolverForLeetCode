class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1 >= 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE;
            int min = Math.min(left, right);
            if (i % 2 == 0) {
                if (nums[i] >= min) {
                    result1 += nums[i] - min + 1;
                }
            } else {
                if (nums[i] >= min) {
                    result2 += nums[i] - min + 1;
                }
            }
        }
        return Math.min(result1, result2);
    }
}