class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[k];
        int stackSize = 0;
        for (int i = 0; i < n; i++) {
            while (stackSize > 0 && stackSize + n - i > k && ans[stackSize - 1] < nums[i]) {
                stackSize--;
            }
            if (stackSize < k) {
                ans[stackSize++] = nums[i];
            }
        }
        return ans;
    }
}