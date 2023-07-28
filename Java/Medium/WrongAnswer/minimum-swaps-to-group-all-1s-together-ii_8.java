class Solution {
    public int minSwaps(int[] nums) {
        
        int len = nums.length;
        int ones = 0;
        for (int i = 0; i < len; i++) {
            ones += nums[i];
        }
        int maxOnes = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += nums[i];
            if (i >= ones) {
                count -= nums[i - ones];
            }
            maxOnes = Math.max(count, maxOnes);
        }
        return ones - maxOnes;
    }
}