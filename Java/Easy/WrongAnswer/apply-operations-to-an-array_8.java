class Solution {
    public int[] applyOperations(int[] nums) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (j == n - 1 || nums[j] != nums[j + 1]) {
                ans[i++] = nums[j];
            } else {
                ans[i++] = 2 * nums[j];
                j++;
            }
        }
        return ans;
    }
}