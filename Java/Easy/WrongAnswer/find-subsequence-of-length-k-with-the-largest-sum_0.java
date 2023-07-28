class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] res = new int[k];
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}