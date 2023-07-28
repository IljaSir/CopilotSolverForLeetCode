class Solution {
    public boolean isGoodArray(int[] nums) {
        
        int gcd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }
        return gcd == 1;
    }
}