class Solution {
    public boolean isGoodArray(int[] nums) {
        
        int g = nums[0];
        for (int i = 1; i < nums.length; i++) {
            g = gcd(nums[i], g);
        }
        return g == 1;
    }
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}