class Solution {
    public int subsetXORSum(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int max = (int) Math.pow(2, nums.length) - 1;
        for (int i = 1; i <= max; i++) {
            int xor = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    xor ^= nums[j];
                }
            }
            sum += xor;
        }
        return sum;
    }
}