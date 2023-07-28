class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int res = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; ++i) {
            int j = n - 1;
            while (j - i > 1) {
                int mid = (j + i) / 2;
                long leftSum = sum[mid] - sum[i];
                long leftCnt = mid - i;
                long rightSum = sum[n - 1] - sum[mid];
                long rightCnt = n - mid;
                if (leftSum * rightCnt < rightSum * leftCnt) {
                    j = mid;
                } else {
                    i = mid;
                }
            }
            long leftSum = sum[i] - sum[res];
            long leftCnt = i - res;
            long rightSum = sum[n - 1] - sum[i];
            long rightCnt = n - i;
            if (leftSum * rightCnt < rightSum * leftCnt) {
                min = leftSum * rightCnt;
                res = i;
            }
            leftSum = sum[j] - sum[res];
            leftCnt = j - res;
            rightSum = sum[n - 1] - sum[j];
            rightCnt = n - j;
            if (leftSum * rightCnt < rightSum * leftCnt) {
                min = leftSum * rightCnt;
                res = j;
            }
        }
        return res;
    }
}