class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] ^ nums[i];
        }
        for (int i = 0; i < n; i++) {
            int x = pre[n - i - 1];
            int y = (1 << maximumBit) - 1;
            ans[i] = x ^ y;
        }
        return ans;
    }
}