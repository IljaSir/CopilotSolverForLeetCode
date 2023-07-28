class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int left = sum[i];
            int right = sum[n - 1] - sum[i];
            int cur = Math.abs(left - right);
            if (cur < min) {
                min = cur;
                res = i;
            }
        }
        return res;
    }
}