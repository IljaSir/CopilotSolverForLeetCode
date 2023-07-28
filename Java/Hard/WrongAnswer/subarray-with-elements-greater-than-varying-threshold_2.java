class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int left = 1;
        int right = n;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(prefix, mid, threshold)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    
    private boolean check(int[] prefix, int k, int threshold) {
        for (int i = k; i < prefix.length; i++) {
            if (prefix[i] - prefix[i - k] >= threshold) {
                return true;
            }
        }
        return false;
    }
}