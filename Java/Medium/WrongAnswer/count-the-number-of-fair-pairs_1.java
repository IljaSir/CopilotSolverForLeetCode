class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            long low = prefix[i] + lower;
            long high = prefix[i] + upper;
            int l = i + 1;
            int r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (prefix[m] < low) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int start = l;
            l = i + 1;
            r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (prefix[m] <= high) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int end = l;
            count += end - start;
        }
        return count;
    }
}