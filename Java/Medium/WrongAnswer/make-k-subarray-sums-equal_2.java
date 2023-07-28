class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        int n = arr.length;
        long[] sum = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
            sum[i] = total;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = i + k - 1;
            if (j >= n) {
                j -= n;
            }
            long cur = 0;
            if (i == 0) {
                cur = sum[j];
            } else {
                cur = sum[j] - sum[i - 1];
            }
            ans = Math.min(ans, total - cur);
        }
        return ans;
    }
}