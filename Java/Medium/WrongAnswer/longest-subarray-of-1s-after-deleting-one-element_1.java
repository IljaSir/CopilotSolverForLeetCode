class Solution {
    public int longestSubarray(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            left[i] = count;
        }
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            right[i] = count;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, (i > 0 ? left[i - 1] : 0) + (i < n - 1 ? right[i + 1] : 0));
            }
        }
        return res;
    }
}