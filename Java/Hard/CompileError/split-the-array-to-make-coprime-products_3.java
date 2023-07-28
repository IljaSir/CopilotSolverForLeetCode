class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            left[i] = gcd(left[i-1], nums[i]);
            right[n-i-1] = gcd(right[n-i], nums[n-i-1]);
        }
        for (int i = 0; i < n; i++) {
            int l = i > 0 ? left[i-1] : 1;
            int r = i < n - 1 ? right[i+1] : 1;
            if (gcd(l, r) == 1) return i;
        }
        return -1;
    }
}