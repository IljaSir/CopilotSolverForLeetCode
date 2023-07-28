class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % gcd != 0) {
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