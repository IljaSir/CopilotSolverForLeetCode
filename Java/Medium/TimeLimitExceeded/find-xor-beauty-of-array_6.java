class Solution {
    public int xorBeauty(int[] nums) {
        
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int m = nums[j];
                for (int k = 0; k < nums.length; k++) {
                    int l = nums[k];
                    xor = xor ^ ((n | m) & l);
                }
            }
        }
        return xor;
    }
}