class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = nums[i];
            right[i] = nums[i];
        }
        int res1 = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1 >= 0 ? left[i - 1] : Integer.MAX_VALUE;
            int r = i + 1 < n ? left[i + 1] : Integer.MAX_VALUE;
            if (nums[i] >= Math.min(l, r)) {
                res1 += nums[i] - Math.min(l, r) + 1;
                left[i] = Math.min(l, r) - 1;
            }
        }
        int res2 = 0;
        for (int i = 0; i < n; i++) {
            int l = i - 1 >= 0 ? right[i - 1] : Integer.MAX_VALUE;
            int r = i + 1 < n ? right[i + 1] : Integer.MAX_VALUE;
            if (nums[i] >= Math.min(l, r)) {
                res2 += nums[i] - Math.min(l, r) + 1;
                right[i] = Math.min(l, r) - 1;
            }
        }
        return Math.min(res1, res2);
    }
}