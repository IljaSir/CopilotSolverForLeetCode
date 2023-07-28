class Solution {
    public int longestSubarray(int[] nums) {
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            left[i] = count;
        }
        count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            right[i] = count;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i == 0) {
                    res = Math.max(res, right[i + 1]);
                } else if (i == nums.length - 1) {
                    res = Math.max(res, left[i - 1]);
                } else {
                    res = Math.max(res, left[i - 1] + right[i + 1]);
                }
            }
        }
        return res;
    }
}