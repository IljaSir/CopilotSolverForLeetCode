class Solution {
    public int findGCD(int[] nums) {
        
        int min = 1001;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return gcd(min, max);
    }
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}