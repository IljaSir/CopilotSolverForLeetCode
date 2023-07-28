class Solution {
    public boolean isGoodArray(int[] nums) {
        
        int g = nums[0];
        for (int n : nums) {
            g = gcd(g, n);
        }
        return g == 1;
    }
    
    int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}