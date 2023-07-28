class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        int n = arr.length;
        long[] sum = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = sum[i] - i / k * k;
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            long cur = 0;
            for (int j = i; j < n; j += k) {
                cur += Math.abs(diff[j] - diff[i]);
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}