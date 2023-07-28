class Solution {
    public boolean isGoodArray(int[] nums) {
        
        int g = 0;
        for (int i = 0; i < nums.length; i++) {
            g = gcd(nums[i], g);
            if (g == 1) return true;
        }
        return false;
    }
}