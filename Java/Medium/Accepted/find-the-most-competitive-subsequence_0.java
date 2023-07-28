class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && ans[j - 1] > nums[i] && j + n - i > k) {
                j--;
            }
            if (j < k) {
                ans[j++] = nums[i];
            }
        }
        return ans;
    }
}