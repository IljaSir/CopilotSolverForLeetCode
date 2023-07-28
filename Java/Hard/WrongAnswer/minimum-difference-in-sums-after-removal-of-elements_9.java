class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum1 += nums[i];
                a[i] = sum1;
            } else {
                sum2 += nums[i];
                b[i] = sum2;
            }
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (i % 2 == 0) {
                long sum = a[i] - (j >= 0 ? b[j] : 0);
                min = Math.min(min, sum);
            } else {
                long sum = (j >= 0 ? a[j] : 0) - b[i];
                min = Math.min(min, sum);
            }
        }
        return min;
    }
}