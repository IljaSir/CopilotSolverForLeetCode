class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            int l = lower + nums[i];
            int r = upper + nums[i];
            int left = find(sums, l, i, n - 1);
            int right = find(sums, r, i, n - 1);
            if (left == -1) {
                continue;
            }
            if (right == -1) {
                right = n - 1;
            }
            count += right - left + 1;
        }
        return count;
    }

    private int find(int[] sums, int target, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (sums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (sums[l] >= target) {
            return l;
        }
        return -1;
    }
}