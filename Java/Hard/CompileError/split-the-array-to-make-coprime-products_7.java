class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            left[i] = gcd(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = gcd(right[i + 1], nums[i]);
        }
        for (int i = 0; i < n - 1; ++i) {
            int leftVal = i > 0 ? left[i - 1] : 1;
            int rightVal = i < n - 2 ? right[i + 1] : 1;
            if (gcd(leftVal, rightVal) == 1) {
                return i;
            }
        }
        return -1;
    }
}