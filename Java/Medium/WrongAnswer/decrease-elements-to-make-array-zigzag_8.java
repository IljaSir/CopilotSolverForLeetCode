class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return 0;
        int[] a = Arrays.copyOf(nums, n);
        int[] b = Arrays.copyOf(nums, n);
        for (int i = 1; i < n; i += 2) {
            if (i < n - 1) a[i] = Math.min(nums[i - 1], nums[i + 1]) - 1;
            else a[i] = nums[i - 1] - 1;
            if (i > 1) b[i] = Math.min(nums[i - 1], nums[i - 2]) - 1;
            else b[i] = nums[i + 1] - 1;
        }
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] < 0) c1 -= a[i];
            if (b[i] < 0) c2 -= b[i];
        }
        return Math.min(c1, c2);
    }
}