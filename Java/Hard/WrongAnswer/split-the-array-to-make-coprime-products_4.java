class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = gcd(prefix[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], nums[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (gcd(prefix[i], suffix[i + 1]) == 1) {
                return i + 1;
            }
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