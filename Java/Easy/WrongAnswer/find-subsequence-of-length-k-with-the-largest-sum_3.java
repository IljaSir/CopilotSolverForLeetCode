class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[k];
        int l = 0, r = n - k;
        for (int i = 0; i < k; i++) {
            res[i] = nums[l] > nums[r] ? nums[l++] : nums[r++];
        }
        return res;
    }
}