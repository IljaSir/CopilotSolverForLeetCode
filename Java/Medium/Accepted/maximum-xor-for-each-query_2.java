class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int[] answer = new int[nums.length];
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = x ^ ((1 << maximumBit) - 1);
            x ^= nums[nums.length - 1 - i];
        }
        return answer;
    }
}