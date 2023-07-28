class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] gcd = new int[n];
        int[] gcd2 = new int[n];
        gcd[n - 1] = nums[n - 1];
        gcd2[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            gcd[i] = gcd(gcd[i + 1], nums[i]);
            gcd2[i] = gcd(gcd2[i + 1], gcd[i]);
        }
        int[] gcd3 = new int[n];
        gcd3[0] = nums[0];
        for (int i = 1; i < n; i++) {
            gcd3[i] = gcd(gcd3[i - 1], nums[i]);
        }
        int[] gcd4 = new int[n];
        gcd4[0] = nums[0];
        for (int i = 1; i < n; i++) {
            gcd4[i] = gcd(gcd4[i - 1], gcd3[i]);
        }
        if (gcd3[n - 1] == 1) {
            return n - 2;
        }
        for (int i = 1; i < n - 1; i++) {
            if (gcd4[i - 1] == 1 && gcd2[i + 1] == 1) {
                return i - 1;
            }
        }
        if (gcd4[n - 2] == 1) {
            return n - 2;
        }
        return -1;
    }
    
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}