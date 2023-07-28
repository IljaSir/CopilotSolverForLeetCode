class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int max = nums[k];
        int l = k;
        int r = k;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (l > 0 && (r == n - 1 || nums[l - 1] > nums[r + 1])) {
                l--;
            } else {
                r++;
            }
            max = Math.max(max, Math.min(nums[l], nums[r]) * (r - l + 1));
        }
        return max;
    }
}