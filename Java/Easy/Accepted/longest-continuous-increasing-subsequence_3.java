class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}