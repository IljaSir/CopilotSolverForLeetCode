class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int len = nums.length;
        int[] result = new int[len];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i < len; i++) {
            result[i] = xor ^ ((1 << maximumBit) - 1);
            xor ^= nums[len - 1 - i];
        }
        return result;
    }
}