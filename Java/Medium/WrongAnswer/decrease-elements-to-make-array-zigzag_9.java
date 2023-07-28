class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int result = 0;
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            int min = Math.min(left, right);
            if (nums[i] >= min) {
                result += nums[i] - min + 1;
                nums[i] = min - 1;
            }
        }
        int result2 = 0;
        for (int i = 0; i < numsCopy.length; i++) {
            int left = i > 0 ? numsCopy[i - 1] : Integer.MAX_VALUE;
            int right = i < numsCopy.length - 1 ? numsCopy[i + 1] : Integer.MAX_VALUE;
            int min = Math.min(left, right);
            if (numsCopy[i] >= min) {
                result2 += numsCopy[i] - min + 1;
                numsCopy[i] = min - 1;
            }
        }
        return Math.min(result, result2);
    }
}