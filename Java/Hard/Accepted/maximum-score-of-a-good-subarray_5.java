class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int left = k;
        int right = k;
        int min = nums[k];
        int max = min * (right - left + 1);
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
            max = Math.max(max, min * (right - left + 1));
        }
        return max;
    }
}