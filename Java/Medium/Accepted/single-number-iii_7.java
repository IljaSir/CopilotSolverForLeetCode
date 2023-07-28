class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[] result = new int[2];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp ^ nums[i];
        }
        int mask = 1;
        while ((temp & mask) == 0) {
            mask = mask << 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                result[0] = result[0] ^ nums[i];
            } else {
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }
}