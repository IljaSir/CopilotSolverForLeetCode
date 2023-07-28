class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[] result = new int[2];
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int bit = 0;
        for(int i = 0; i < 32; i++) {
            if((xor & (1 << i)) != 0) {
                bit = i;
                break;
            }
        }
        int x = 0;
        int y = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & (1 << bit)) == 0) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }
        }
        result[0] = x;
        result[1] = y;
        return result;
    }
}