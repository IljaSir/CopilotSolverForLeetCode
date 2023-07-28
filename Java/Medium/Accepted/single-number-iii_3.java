class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lastBit = xor & (-xor);
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & lastBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}