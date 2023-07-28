class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int bit = 1;
        while ((xor & bit) == 0) {
            bit <<= 1;
        }
        int[] res = new int[2];
        for (int i : nums) {
            if ((i & bit) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}