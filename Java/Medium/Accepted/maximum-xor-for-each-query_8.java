class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int n = nums.length;
        int[] ans = new int[n];
        int a = 0;
        for (int i = 0; i < n; i++) {
            a ^= nums[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = a ^ ((1 << maximumBit) - 1);
            a ^= nums[n - 1 - i];
        }
        return ans;
    }
}