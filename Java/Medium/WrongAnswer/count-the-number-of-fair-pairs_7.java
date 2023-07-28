class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        long count = 0;
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int[] countPrefix = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            countPrefix[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            count += countPrefix[upperBound(prefix, prefix[i] - lower)] - countPrefix[lowerBound(prefix, prefix[i] - upper)];
        }
        return count;
    }
    public int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}