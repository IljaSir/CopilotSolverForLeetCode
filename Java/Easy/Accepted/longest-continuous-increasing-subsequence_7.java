class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int max = 1;
        int l = 0;
        int r = 1;
        while (r < n) {
            if (nums[r] > nums[r - 1]) {
                r++;
            } else {
                max = Math.max(max, r - l);
                l = r;
                r++;
            }
        }
        return Math.max(max, r - l);
    }
}