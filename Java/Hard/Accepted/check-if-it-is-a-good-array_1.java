class Solution {
    public boolean isGoodArray(int[] nums) {
        
        int gcd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }
        return gcd == 1;
    }
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}