class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int left = k, right = k;
        int min = nums[k];
        int res = min;
        while (left > 0 || right < nums.length - 1) {
            if (left == 0) {
                right++;
            } else if (right == nums.length - 1) {
                left--;
            } else if (nums[left - 1] < nums[right + 1]) {
                right++;
            } else {
                left--;
            }
            min = Math.min(min, Math.min(nums[left], nums[right]));
            res = Math.max(res, min * (right - left + 1));
        }
        return res;
    }
}