class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }
            if (min < nums[n - i - 1]) {
                l = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return r == -1 ? 0 : r - l + 1;
    }
}