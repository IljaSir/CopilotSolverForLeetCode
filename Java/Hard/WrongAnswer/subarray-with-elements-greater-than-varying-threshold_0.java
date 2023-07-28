class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(m, sum, threshold)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return check(l, sum, threshold) ? l : -1;
    }
    
    private boolean check(int m, int[] sum, int threshold) {
        for (int i = 0; i + m <= sum.length; i++) {
            int s = sum[i + m - 1] - (i == 0 ? 0 : sum[i - 1]);
            if (s >= threshold) {
                return true;
            }
        }
        return false;
    }
}