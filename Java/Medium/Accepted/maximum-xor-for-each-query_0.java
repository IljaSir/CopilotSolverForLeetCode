class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int n = nums.length;
        int[] res = new int[n];
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = xor ^ ((1 << maximumBit) - 1);
            xor ^= nums[n - 1 - i];
        }
        return res;
    }
}