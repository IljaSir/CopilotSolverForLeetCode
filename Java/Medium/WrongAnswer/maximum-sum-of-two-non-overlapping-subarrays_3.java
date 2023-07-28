class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = firstLen; i <= n; i++) {
            int first = sum[i] - sum[i - firstLen];
            int max = 0;
            for (int j = 0; j < i - firstLen; j++) {
                max = Math.max(max, sum[j + secondLen] - sum[j]);
            }
            for (int j = i + secondLen; j <= n; j++) {
                max = Math.max(max, sum[j] - sum[j - secondLen]);
            }
            res = Math.max(res, first + max);
        }
        return res;
    }
}