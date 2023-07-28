class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int gcdOfDivide = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gcdOfDivide = gcd(gcdOfDivide, numsDivide[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i] % gcdOfDivide);
        }
        if (min == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % gcdOfDivide == min) {
                count++;
            }
        }
        return count;
    }
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}