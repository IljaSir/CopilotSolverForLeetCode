class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[] result = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        result[0] = xor1;
        result[1] = xor2;
        return result;
    }
}