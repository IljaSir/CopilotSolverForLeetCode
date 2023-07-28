class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        if (n < 2) return false;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = sum[j] - sum[i] + nums[i];
                if (s == k || (k != 0 && s % k == 0)) return true;
            }
        }
        return false;
    }
}