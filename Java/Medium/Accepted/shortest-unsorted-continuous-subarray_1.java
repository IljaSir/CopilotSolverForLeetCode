class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - 1 - i] > min) {
                start = nums.length - 1 - i;
            } else {
                min = nums[nums.length - 1 - i];
            }
        }
        return start == -1 ? 0 : end - start + 1;
    }
}