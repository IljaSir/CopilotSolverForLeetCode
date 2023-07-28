class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int l = 0, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (canFind(prefix, threshold, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l == n + 1 ? -1 : l;
    }
    private boolean canFind(int[] prefix, int threshold, int k) {
        for (int i = k; i < prefix.length; i++) {
            if (prefix[i] - prefix[i - k] > threshold) {
                return true;
            }
        }
        return false;
    }
}