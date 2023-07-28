class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[] result = new int[2];
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if (((xor >> i) & 1) == 1) {
                index = i;
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> index) & 1) == 1) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        result[0] = a;
        result[1] = b;
        return result;
    }
}