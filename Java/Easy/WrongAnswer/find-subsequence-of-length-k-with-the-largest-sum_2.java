class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        int[] result = new int[k];
        
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && result[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                result[j++] = nums[i];
            }
        }
        return result;
    }
}