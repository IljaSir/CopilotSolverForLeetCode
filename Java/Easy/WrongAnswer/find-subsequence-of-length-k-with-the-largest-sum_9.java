class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] res = new int[k];
        int n = nums.length;
        int max = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (n - i + j > k && nums[i] < max) {
                continue;
            }
            res[j++] = nums[i];
            if (j == k) {
                break;
            }
        }
        return res;
    }
}