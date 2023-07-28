class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long sum1 = 0;
        for (int i = n; i < 2 * n; i++) {
            sum1 += nums[i];
        }
        long sum2 = 0;
        for (int i = 2 * n; i < 3 * n; i++) {
            sum2 += nums[i];
        }
        long res = Math.abs(sum - sum1) + Math.abs(sum2 - sum1) + Math.abs(sum - sum2);
        for (int i = 1; i < n; i++) {
            long s1 = sum - nums[i - 1] + nums[i + n - 1];
            long s2 = sum1 - nums[i + n - 1] + nums[i + 2 * n - 1];
            long s3 = sum2 - nums[i + 2 * n - 1] + nums[i - 1];
            res = Math.min(res, Math.abs(s1 - s2) + Math.abs(s2 - s3) + Math.abs(s1 - s3));
        }
        return res;
    }
}