class Solution {
    public int singleNumber(int[] nums) {
        
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            for (int j = 0; j < 32; j++) {
                if ((tmp & 1) == 1) {
                    bit[j]++;
                }
                tmp >>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res += bit[i] % 3;
        }
        return res;
    }
}